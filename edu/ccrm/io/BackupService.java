package edu.ccrm.io;

import java.nio.file.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BackupService {
    public void backupData(String sourceDir, String backupRootDir) throws IOException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        Path backupDir = Paths.get(backupRootDir, "backup_" + timestamp);
        Files.createDirectories(backupDir);
        Files.walk(Paths.get(sourceDir))
            .forEach(source -> {
                try {
                    Path dest = backupDir.resolve(Paths.get(sourceDir).relativize(source));
                    if (Files.isDirectory(source)) {
                        Files.createDirectories(dest);
                    } else {
                        Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        System.out.println("Backup completed to: " + backupDir);
    }

    public long computeBackupSize(String backupDir) throws IOException {
        return Files.walk(Paths.get(backupDir))
            .filter(Files::isRegularFile)
            .mapToLong(path -> {
                try {
                    return Files.size(path);
                } catch (IOException e) {
                    return 0L;
                }
            }).sum();
    }
}
