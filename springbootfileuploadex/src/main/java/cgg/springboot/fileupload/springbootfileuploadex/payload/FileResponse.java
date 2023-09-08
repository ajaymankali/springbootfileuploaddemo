package cgg.springboot.fileupload.springbootfileuploadex.payload;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor

public class FileResponse {
    
    private String fileName;
    private String message;

}
