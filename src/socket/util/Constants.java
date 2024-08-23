package socket.util;

import java.util.Map;

public class Constants {
    public static final String QUIT_COMMAND = "0";
    public static final String USER_COMMAND = "1";
    public static final String PASS_COMMAND = "2";
    public static final String PASV_COMMAND = "3";
    public static final String LIST_COMMAND = "4";
    public static final String RETR_COMMAND = "5";
    public static final String STOR_COMMAND = "6";
    public static final String COMMAND_SEPARATOR = " ";
    public static final String SUCCESS = "200";
    public static final String FAILED = "300";

    public static final String SYNTAX_ERROR_IN_PARAMETERS_OR_ARGUMENTS = "501 Syntax error in parameters or arguments.";

    public static final String NOT_LOGGED_IN = "530 Not logged in.";
    public static final String GOODBYE = "221 Goodbye.";
    public static final String COMMAND_NOT_IMPLEMENTED = "502 Command not implemented.";
    public static final String USERNAME_OKAY_NEED_PASSWORD = "331 Username okay, need password.";
    public static final String USER_LOGGED_IN_PROCEED = "230 User logged in, proceed.";
    public static final String rootDir = "D:\\YT\\Java\\";
}
