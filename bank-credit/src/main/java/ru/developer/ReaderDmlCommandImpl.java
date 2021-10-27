package ru.developer;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Component
public class ReaderDmlCommandImpl implements ReaderDmlCommand {

    @Override
    public String getQueryFromFile() {
        try (InputStream resource = new ClassPathResource("dmlcommand.sql").getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(resource))) {

            return reader.lines()
                    .collect(Collectors.joining(";"));

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0); // Стоит ли останавливать JVM?
        }
        return null;
    }

}
