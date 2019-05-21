package com.codeclan.filesystem;

import com.codeclan.filesystem.models.File;
import com.codeclan.filesystem.models.Folder;
import com.codeclan.filesystem.models.User;
import com.codeclan.filesystem.repositories.FileRepository;
import com.codeclan.filesystem.repositories.FolderRepository;
import com.codeclan.filesystem.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jws.soap.SOAPBinding;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FilesystemApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	FileRepository fileRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createFilesFoldersAndUsers() {

		User user = new User("Joan");
		userRepository.save(user);

		Folder folder = new Folder("codeclan", user);
		folderRepository.save(folder);

		Folder folder1 = new Folder("e29-classnotes", user);
		folderRepository.save(folder1);

		File file = new File("day_1","js", 2, folder);
		fileRepository.save(file);

		user.addFolder(folder);
		userRepository.save(user);

		user.addFolder(folder1);
		userRepository.save(user);
	}

	@Test
	public void deleteFilesAndFolders(){

		User user = new User("Joan");
		userRepository.save(user);
		userRepository.delete(user);

		Folder folder = new Folder("e29-classnotes", user);
		folderRepository.save(folder);
		folderRepository.delete(folder);

		File file = new File("day_1","js", 2, folder);
		fileRepository.save(file);

		folder.addFiles(file);
		folderRepository.save(folder);

	}

}
