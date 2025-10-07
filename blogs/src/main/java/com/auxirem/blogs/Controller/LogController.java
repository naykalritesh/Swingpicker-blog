package com.auxirem.blogs.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

@RestController
@RequestMapping("/blogs/api")
public class LogController {

    // Log file path from application.properties or default
    @Value("${app.log.file.path:logs/application.log}")
    private String logFilePath;

    @GetMapping("/logs")
    public List<String> getLogs() throws IOException {
        Path path = Paths.get(logFilePath);

        if (!Files.exists(path)) {
            return List.of("Log file not found: " + logFilePath);
        }

        // Read all lines of the log file
        return Files.readAllLines(path);
    }
}

