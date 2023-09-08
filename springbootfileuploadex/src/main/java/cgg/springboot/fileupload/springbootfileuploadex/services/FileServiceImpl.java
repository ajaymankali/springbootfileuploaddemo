package cgg.springboot.fileupload.springbootfileuploadex.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
       //controller is used to return view 
       //rest controller is used to return json or xml data

       //Generating random names for files that we upload
       String randomID = UUID.randomUUID().toString();



       //filename
        String name = file.getOriginalFilename();
        String fileName1="";
        if(name.length()>0){
         fileName1 = randomID.concat(name.substring(name.lastIndexOf(".")));
        }

       //fullpath
        String filePath="";
        if(fileName1.equals("")){
         filePath= path+File.separator+name;
        }
        else{
            filePath=path+File.separator+fileName1;
        }

       //create folder if not created
        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
        }
       //file copy
        Files.copy(file.getInputStream(), Paths.get(filePath));
       //return filename ie string
       return name;
    }

    @Override
    public InputStream getResouce(String path, String fileName) throws FileNotFoundException {
      

        String fullpath = path+File.separator+fileName;
        FileInputStream fis = new FileInputStream(fullpath);

        return fis;
    }

    
}
