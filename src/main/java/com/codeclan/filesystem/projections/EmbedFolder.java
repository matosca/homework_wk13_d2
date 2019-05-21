package com.codeclan.filesystem.projections;

import com.codeclan.filesystem.models.File;
import com.codeclan.filesystem.models.Folder;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "embedFolder", types = File.class)
public interface EmbedFolder {

    String getName();
    String getExtension();
    int getSize();
    Folder getFolder();
}
