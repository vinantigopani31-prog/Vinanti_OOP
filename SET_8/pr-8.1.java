import java.io.*;
import java.util.Date;

public class FileOperations {

    // Method to display file properties
    public static void showFileProperties(File file) {
        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }

        System.out.println("\n--- File Properties ---");
        System.out.println("File Name: " + file.getName());
        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("File Size: " + file.length() + " bytes");
        System.out.println("Readable: " + file.canRead());
        System.out.println("Writable: " + file.canWrite());
        System.out.println("Last Modified: " + new Date(file.lastModified()));
    }

    // Method to copy file
    public static void copyFile(String source, String destination) throws IOException {
        File srcFile = new File(source);
        File destFile = new File(destination);

        if (!srcFile.exists()) {
            throw new FileNotFoundException("Source file not found.");
        }

        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(destFile);

        int data;
        while ((data = fis.read()) != -1) {
            fos.write(data);
        }

        fis.close();
        fos.close();

        System.out.println("File copied successfully.");
        showFileProperties(destFile);
    }

    // Method to delete file
    public static void deleteFile(String filename) {
        File file = new File(filename);

        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete file.");
            }
        } else {
            System.out.println("File not found.");
        }
    }

    // Method to rename file
    public static void renameFile(String oldName, String newName) {
        File oldFile = new File(oldName);
        File newFile = new File(newName);

        if (!oldFile.exists()) {
            System.out.println("File not found.");
            return;
        }

        if (oldFile.renameTo(newFile)) {
            System.out.println("File renamed successfully.");
            showFileProperties(newFile);
        } else {
            System.out.println("Failed to rename file.");
        }
    }

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Usage:");
            System.out.println("copy <source> <destination>");
            System.out.println("delete <filename>");
            System.out.println("rename <oldname> <newname>");
            return;
        }

        String command = args[0];

        try {
            switch (command.toLowerCase()) {

                case "copy":
                    if (args.length != 3) {
                        System.out.println("Usage: copy <source> <destination>");
                        return;
                    }
                    copyFile(args[1], args[2]);
                    break;

                case "delete":
                    deleteFile(args[1]);
                    break;

                case "rename":
                    if (args.length != 3) {
                        System.out.println("Usage: rename <oldname> <newname>");
                        return;
                    }
                    renameFile(args[1], args[2]);
                    break;

                default:
                    System.out.println("Invalid command.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}