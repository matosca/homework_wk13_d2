package com.codeclan.filesystem.projections;

import com.codeclan.filesystem.models.File;
import com.codeclan.filesystem.models.Folder;
import com.codeclan.filesystem.models.User;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "embedUser", types = Folder.class)
public interface EmbedUser {

    String getTitle();
    List<File> getFiles();
    User getUser();

}
