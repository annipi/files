package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.util.Objects;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
class FilesApplication {

    private static ArrayList<GearLibraryDTO> files = new ArrayList<GearLibraryDTO>();
    private static ArrayList<File> folders = new ArrayList<File>();

    public static void listFiles(final String folderId) {
        String gearRepo = "/home/luis/Documents/jhipster/gear-2020/src/main/resources/DocIntegradosGEAR";
        File folder = new File(gearRepo);
    }

    public static List<GearLibraryDTO> readFileFromCSV(String folderPath, String indexFiles) {
        Path pathToFile = Paths.get(folderPath + "/" + indexFiles);

        try {
            List<String> contents = Files.readAllLines(pathToFile, StandardCharsets.ISO_8859_1);

            for (String content : contents) {
                String[] attributes = content.split(";");
                String fileName = attributes[0];

                if(!fileName.equals("Archivo")){
                    GearLibraryDTO dto = new GearLibraryDTO();
                    dto.setDocumentName(fileName);
                    dto.setDocumentDomain(attributes[3]);
                    dto.setDocumentTitle(fileName.substring(0, fileName.lastIndexOf(".")));
                    dto.setDocumentType(fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()));
                    dto.setValueField(folderPath + "/" + fileName);

                    files.add(dto);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }

    public static void listFilesByFolder(final File folder) {

        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                //System.out.println(">>>>>>>> Folder: "+fileEntry);
                listFilesByFolder(fileEntry);
                folders.add(fileEntry);
            }
        }
    }

    public static void main(String[] args) {
        // String gearRepo = System.getenv("GEAR_REPO");
        String gearRepo = "/home/luis/Documents/jhipster/demo/src/main/resources/DocIntegradosGEAR";
//        System.out.println("Gear repo: " + gearRepo);
        File folder = new File(gearRepo);
        listFilesByFolder(folder);

        String indexFiles = "indexFiles.csv";
        int count = 0;

        for (File folderPath : folders) {
            if (new File(folderPath, indexFiles).exists()) {
                // TODO add path join instead of "/"
                readFileFromCSV(folderPath.getAbsolutePath(), indexFiles);
                count++;
            }
//            else {
//                GearLibraryDTO dto = new GearLibraryDTO();
//                dto.setDocumentName(fileName);
//                dto.setDocumentDomain("domain");
//                dto.setDocumentTitle(fileName.substring(0, fileName.lastIndexOf(".")));
//                dto.setDocumentType(fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()));
////                dto.setLabelField("base del conocimiento");
////                dto.setValueField(fileEntry.getAbsolutePath());
//                files.add(dto);
//            }
        }
//
        for (GearLibraryDTO file : files) {
            System.out.println(file.toString());
        }
        // SpringApplication.run(FilesApplication.class, args);
    }

}

class GearLibraryDTO implements Serializable {

    private Long id;

    private String idFile;

    private String documentName;

    private String documentDomain;

    private String documentTitle;

    private String documentType;

    private String documentDescription;

    private Boolean documentIsCopy;

    private Boolean documentIsDraft;

    private String labelField;

    private String typeField;

    private String propertieName;

    private String documentIdAlfresco;

    private String folderIdAlfresco;

    private String nameFolderAlfresco;

    private String siteIdAlfresco;

    private String nameSiteAlfresco;

    private String valueField;

    private Long customFieldId;

    private Long templateId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdFile() {
        return idFile;
    }

    public void setIdFile(String idFile) {
        this.idFile = idFile;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentDomain() {
        return documentDomain;
    }

    public void setDocumentDomain(String documentDomain) {
        this.documentDomain = documentDomain;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentDescription() {
        return documentDescription;
    }

    public void setDocumentDescription(String documentDescription) {
        this.documentDescription = documentDescription;
    }

    public Boolean isDocumentIsCopy() {
        return documentIsCopy;
    }

    public void setDocumentIsCopy(Boolean documentIsCopy) {
        this.documentIsCopy = documentIsCopy;
    }

    public Boolean isDocumentIsDraft() {
        return documentIsDraft;
    }

    public void setDocumentIsDraft(Boolean documentIsDraft) {
        this.documentIsDraft = documentIsDraft;
    }

    public String getLabelField() {
        return labelField;
    }

    public void setLabelField(String labelField) {
        this.labelField = labelField;
    }

    public String getTypeField() {
        return typeField;
    }

    public void setTypeField(String typeField) {
        this.typeField = typeField;
    }

    public String getPropertieName() {
        return propertieName;
    }

    public void setPropertieName(String propertieName) {
        this.propertieName = propertieName;
    }

    public String getDocumentIdAlfresco() {
        return documentIdAlfresco;
    }

    public void setDocumentIdAlfresco(String documentIdAlfresco) {
        this.documentIdAlfresco = documentIdAlfresco;
    }

    public String getFolderIdAlfresco() {
        return folderIdAlfresco;
    }

    public void setFolderIdAlfresco(String folderIdAlfresco) {
        this.folderIdAlfresco = folderIdAlfresco;
    }

    public String getNameFolderAlfresco() {
        return nameFolderAlfresco;
    }

    public void setNameFolderAlfresco(String nameFolderAlfresco) {
        this.nameFolderAlfresco = nameFolderAlfresco;
    }

    public String getSiteIdAlfresco() {
        return siteIdAlfresco;
    }

    public void setSiteIdAlfresco(String siteIdAlfresco) {
        this.siteIdAlfresco = siteIdAlfresco;
    }

    public String getNameSiteAlfresco() {
        return nameSiteAlfresco;
    }

    public void setNameSiteAlfresco(String nameSiteAlfresco) {
        this.nameSiteAlfresco = nameSiteAlfresco;
    }

    public String getValueField() {
        return valueField;
    }

    public void setValueField(String valueField) {
        this.valueField = valueField;
    }

    public Long getCustomFieldId() {
        return customFieldId;
    }

    public void setCustomFieldId(Long customFieldId) {
        this.customFieldId = customFieldId;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GearLibraryDTO gearLibraryDTO = (GearLibraryDTO) o;
        if (gearLibraryDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), gearLibraryDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "GearLibraryDTO{" +
//                "id=" + getId() +
//                ", idFile='" + getIdFile() + "'" +
                ", documentName='" + getDocumentName() + "'" +
                ", documentDomain='" + getDocumentDomain() + "'" +
                ", documentTitle='" + getDocumentTitle() + "'" +
                ", documentType='" + getDocumentType() + "'" +
//                ", documentDescription='" + getDocumentDescription() + "'" +
//                ", documentIsCopy='" + isDocumentIsCopy() + "'" +
//                ", documentIsDraft='" + isDocumentIsDraft() + "'" +
                ", labelField='" + getLabelField() + "'" +
//                ", typeField='" + getTypeField() + "'" +
//                ", propertieName='" + getPropertieName() + "'" +
//                ", documentIdAlfresco='" + getDocumentIdAlfresco() + "'" +
//                ", folderIdAlfresco='" + getFolderIdAlfresco() + "'" +
//                ", nameFolderAlfresco='" + getNameFolderAlfresco() + "'" +
//                ", siteIdAlfresco='" + getSiteIdAlfresco() + "'" +
//                ", nameSiteAlfresco='" + getNameSiteAlfresco() + "'" +
                ", valueField='" + getValueField() + "'" +
//                ", customFieldId=" + getCustomFieldId() +
//                ", templateId=" + getTemplateId() +
                "}";
    }
}
