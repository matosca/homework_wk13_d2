package com.codeclan.filesystem.components;

import com.codeclan.filesystem.models.File;
import com.codeclan.filesystem.models.Folder;
import com.codeclan.filesystem.models.User;
import com.codeclan.filesystem.repositories.FileRepository;
import com.codeclan.filesystem.repositories.FolderRepository;
import com.codeclan.filesystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args) {
        User user = new User("Joan");
        userRepository.save(user);

        Folder folder = new Folder("codeclan", user);
        folderRepository.save(folder);

        File file = new File("day_1","js", 2, folder);
        fileRepository.save(file);


        user.addFolder(folder);
        userRepository.save(user);

        folder.addFiles(file);
        folderRepository.save(folder);

    }
}
