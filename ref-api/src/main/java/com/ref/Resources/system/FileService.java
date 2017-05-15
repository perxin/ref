package com.ref.Resources.system;

import com.github.pagehelper.PageInfo;
import com.ref.base.exception.BusinessException;
import com.ref.model.system.File;

import java.util.List;

public interface FileService {

   File saveFile(File file) throws BusinessException;

   List<File> getFile(Long relationId, String relationType) throws BusinessException;

   void delete(Long id, Long userId) throws BusinessException;

   PageInfo<File> getPage(File file) throws BusinessException;

   void upload(byte[] bytes, Long userId, String name, long size);

   String getFileUrl(Long id);

   File getFile(Long id);
}
