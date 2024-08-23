package file;


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

    public FileSystemEntity(String name) {
        this.name = name;
        this.createdTimestamp = System.currentTimeMillis();
        this.lastModifiedTimestamp = System.currentTimeMillis();
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

    public Directory(String name) {
        super(name);
        this.children = new HashMap<>();
    }

    public void addChild(FileSystemEntity entity) {
        entity.setParent(this);
        children.put(entity.getName(), entity);
    }

    public void removeChild(String name) {
        children.remove(name);
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

    public File(String name) {
        super(name);
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
        this.rootDirectory = new Directory("/");
        this.currentDirectory = rootDirectory;
        this.userGroups = new HashMap<>();

    }
    private boolean hasPermission(FileSystemEntity entity, String userGroup, int requiredPermission) {
        // Check if the user group has access to the entity
        if (entity.getUserGroups().contains(userGroup)) {
            int permission = entity.getPermission(userGroup);
            // Check if the user group has sufficient permission
            if (permission >= requiredPermission) {
                return true;
            }
        }
        return false;
    }

    public void createFile(String name, String userGroup, int requiredPermission) {
        if (hasPermission(currentDirectory, userGroup, requiredPermission)) {
            File file = new File(name);
            currentDirectory.addChild(file);
        } else {
            System.out.println("Insufficient permissions.");
        }
    }

    public void createDirectory(String name, String userGroup, int requiredPermission) {
        if (hasPermission(currentDirectory, userGroup, requiredPermission)) {
            Directory directory = new Directory(name);
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
 /*   public void createFile(String name) {
        File file = new File(name);
        currentDirectory.addChild(file);
    }

    public Directory createDirectory(String name) {
        Directory directory = new Directory(name);
        currentDirectory.addChild(directory);
        return directory;
    }

    public Directory changeDirectory(String name) {
        if (name.equals("..")) {
            if (currentDirectory != rootDirectory) {
                currentDirectory = currentDirectory.getParent();
            }
        } else {
            if (currentDirectory.containsChild(name)) {
                FileSystemEntity entity = currentDirectory.getChild(name);
                if (entity instanceof Directory)
                    currentDirectory = (Directory) entity;
                else
                    throw new IllegalPathStateException("Not a directory.");
            } else
                throw new IllegalPathStateException("Directory not found.");
        }
        return currentDirectory;
    }*/

    public Directory getCurrentDirectory() {
        return currentDirectory;
    }

    public void listFiles() {
        currentDirectory.listChildren();
    }
}

/**
 * In this example, we have three main classes: FileSystemEntity, Directory, and File.
 * FileSystemEntity is an abstract class that represents a generic file system entity and provides
 * common attributes and methods like name and timestamps. Directory extends FileSystemEntity and
 * represents a directory containing other entities (files and subdirectories).
 * File also extends FileSystemEntity and represents a file with its content.
 * The FileSystem class represents the file system itself and provides operations like creating
 * files and directories, changing the current directory, and listing files in the current directory.
 */
public class FileSystemDesign {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();

        // Create user groups
        String userGroup1 = "Group1";
        String userGroup2 = "Group2";

        // Create entities
        fileSystem.createDirectory("documents",userGroup1,2);
        fileSystem.createDirectory("photos",userGroup2,2);
        fileSystem.createFile("notes.txt",userGroup1,2);

        // Set user group and permissions for entities
        Directory documents = (Directory) fileSystem.getCurrentDirectory().getChild("documents");
        documents.addUserGroup(userGroup1);
        documents.setPermission(userGroup1, 2); // Read-write permission for Group1
        documents.addUserGroup(userGroup2);
        documents.setPermission(userGroup2, 1); // Read-only permission for Group2

        File notes = (File) fileSystem.getCurrentDirectory().getChild("notes.txt");
        notes.addUserGroup(userGroup1);
        notes.setPermission(userGroup1, 2); // Read-write permission for Group1
        notes.addUserGroup(userGroup2);
        notes.setPermission(userGroup2, 0); // No permission for Group2

        // Change to "documents" directory
//        fileSystem.changeDirectory("notes.txt");
        fileSystem.changeDirectory("documents",userGroup1,3);

        // Create file in "documents" directory
        fileSystem.createFile("resume.docx",userGroup2,1);

        // List files in "documents" directory
        fileSystem.listFiles();
    }
}
