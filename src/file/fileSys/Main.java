package file.fileSys;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Represents a file or directory
abstract class FileSystemEntity {
    private String name;
    private long createdTimestamp;
    private long lastModifiedTimestamp;
    private Directory parent;
    private Set<String> userGroups;
    private Map<String, Integer> permissions;

    public FileSystemEntity(String name, Directory parent) {
        this.name = name;
        this.createdTimestamp = System.currentTimeMillis();
        this.lastModifiedTimestamp = System.currentTimeMillis();
        this.parent = parent;
        this.userGroups = new HashSet<>();
        this.permissions = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public long getCreatedTimestamp() {
        return createdTimestamp;
    }

    public long getLastModifiedTimestamp() {
        return lastModifiedTimestamp;
    }

    public void setLastModifiedTimestamp(long lastModifiedTimestamp) {
        this.lastModifiedTimestamp = lastModifiedTimestamp;
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public Set<String> getUserGroups() {
        return userGroups;
    }

    public void addUserGroup(String userGroup) {
        userGroups.add(userGroup);
    }

    public void removeUserGroup(String userGroup) {
        userGroups.remove(userGroup);
    }

    public Map<String, Integer> getPermissions() {
        return permissions;
    }

    public void setPermission(String userGroup, int permission) {
        permissions.put(userGroup, permission);
    }

    public int getPermission(String userGroup) {
        return permissions.getOrDefault(userGroup, 0);
    }
}

// Represents a directory
class Directory extends FileSystemEntity {
    private Map<String, FileSystemEntity> children;

    public Directory(String name, Directory parent) {
        super(name, parent);
        this.children = new HashMap<>();
    }

    public void addChild(FileSystemEntity entity) {
        children.put(entity.getName(), entity);
        entity.setParent(this);
    }

    public void removeChild(String name) {
        FileSystemEntity entity = children.remove(name);
        if (entity != null) {
            entity.setParent(null);
        }
    }

    public FileSystemEntity getChild(String name) {
        return children.get(name);
    }

    public boolean containsChild(String name) {
        return children.containsKey(name);
    }

    public void listChildren() {
        for (FileSystemEntity entity : children.values()) {
            System.out.println(entity.getName());
        }
    }
}

// Represents a file
class File extends FileSystemEntity {
    private String content;

    public File(String name, Directory parent) {
        super(name, parent);
        this.content = "";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        setLastModifiedTimestamp(System.currentTimeMillis());
    }
}

// Represents the file system
class FileSystem {
    private Directory rootDirectory;
    private Directory currentDirectory;
    private Map<String, Set<String>> userGroups;

    public FileSystem() {
        this.rootDirectory = new Directory("/", null);
        this.currentDirectory = rootDirectory;
        this.userGroups = new HashMap<>();
    }

    public void createFile(String name, String userGroup, int requiredPermission) {
        if (hasPermission(currentDirectory, userGroup, requiredPermission)) {
            File file = new File(name, currentDirectory);
            currentDirectory.addChild(file);
        } else {
            System.out.println("Insufficient permissions.");
        }
    }

    public void createDirectory(String name, String userGroup, int requiredPermission) {
        if (hasPermission(currentDirectory, userGroup, requiredPermission)) {
            Directory directory = new Directory(name, currentDirectory);
            currentDirectory.addChild(directory);
        } else {
            System.out.println("Insufficient permissions.");
        }
    }

    public void changeDirectory(String name, String userGroup, int requiredPermission) {
        if (hasPermission(currentDirectory, userGroup, requiredPermission)) {
            if (name.equals("..")) {
                if (currentDirectory != rootDirectory) {
                    currentDirectory = currentDirectory.getParent();
                }
            } else {
                if (currentDirectory.containsChild(name)) {
                    FileSystemEntity entity = currentDirectory.getChild(name);
                    if (entity instanceof Directory) {
                        if (hasPermission(entity, userGroup, requiredPermission)) {
                            currentDirectory = (Directory) entity;
                        } else {
                            System.out.println("Insufficient permissions.");
                        }
                    } else {
                        System.out.println("Not a directory.");
                    }
                } else {
                    System.out.println("Directory not found.");
                }
            }
        } else {
            System.out.println("Insufficient permissions.");
        }
    }

    public void listFiles(String userGroup, int requiredPermission) {
        if (hasPermission(currentDirectory, userGroup, requiredPermission)) {
            currentDirectory.listChildren();
        } else {
            System.out.println("Insufficient permissions.");
        }
    }

    private boolean hasPermission(FileSystemEntity entity, String userGroup, int requiredPermission) {
        if (entity.getUserGroups().contains(userGroup)) {
            int permission = entity.getPermission(userGroup);
            if (permission >= requiredPermission) {
                return true;
            }
        }
        return false;
    }

    public Directory getCurrentDirectory() {
        return currentDirectory;
    }

    public void addUserGroup(String userGroup) {
        userGroups.put(userGroup, new HashSet<>());
    }

    public void removeUserGroup(String userGroup) {
        userGroups.remove(userGroup);
    }

    public void addUserToGroup(String user, String userGroup) {
        Set<String> users = userGroups.getOrDefault(userGroup, new HashSet<>());
        users.add(user);
        userGroups.put(userGroup, users);
    }

    public void removeUserFromGroup(String user, String userGroup) {
        Set<String> users = userGroups.getOrDefault(userGroup, new HashSet<>());
        users.remove(user);
        userGroups.put(userGroup, users);
    }

    public void setPermission(String userGroup, FileSystemEntity entity, int permission) {
        entity.setPermission(userGroup, permission);
    }

    public int getPermission(String userGroup, FileSystemEntity entity) {
        return entity.getPermission(userGroup);
    }
}

public class Main {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();

        // Create user groups
        String userGroup1 = "Group1";
        String userGroup2 = "Group2";

        // Add users to groups
        fileSystem.addUserGroup(userGroup1);
        fileSystem.addUserGroup(userGroup2);
        fileSystem.addUserToGroup("User1", userGroup1);
        fileSystem.addUserToGroup("User2", userGroup2);

        // Create entities
        fileSystem.createDirectory("documents", userGroup1, 2);
        fileSystem.createDirectory("photos", userGroup1, 1);
        fileSystem.createFile("notes.txt", userGroup1, 2);

        // Set permissions for entities
        Directory documents = (Directory) fileSystem.getCurrentDirectory().getChild("documents");
        fileSystem.setPermission(userGroup1, documents, 2);
        fileSystem.setPermission(userGroup2, documents, 1);

        File notes = (File) fileSystem.getCurrentDirectory().getChild("notes.txt");
        fileSystem.setPermission(userGroup1, notes, 3);
        fileSystem.setPermission(userGroup2, notes, 2);

        // List files in the current directory
        fileSystem.listFiles(userGroup1, 1);

        // Change to the "documents" directory
        fileSystem.changeDirectory("documents", userGroup1, 2);

        // List files in the current directory
        fileSystem.listFiles(userGroup1, 1);
        fileSystem.listFiles(userGroup2, 1);
    }
}
