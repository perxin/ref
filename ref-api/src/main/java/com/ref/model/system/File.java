package com.ref.model.system;

import com.ref.base.model.BaseEntity;

public class File extends BaseEntity {

    private static final long serialVersionUID = 1834829795537429154L;

    private Long id;

    private Long relationId;

    private String relationType;

    private String fileUrl;

    private String fileName;

    private String fileSize;

    public File() {
    }

    public File(Long id, Long relationId, String relationType, String fileUrl, String fileName, String fileSize) {
        this.id = id;
        this.relationId = relationId;
        this.relationType = relationType;
        this.fileUrl = fileUrl;
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType == null ? null : relationType.trim();
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize == null ? null : fileSize.trim();
    }

    @Override
    public Object getPrimaryKey() {
        return this.id;
    }
}