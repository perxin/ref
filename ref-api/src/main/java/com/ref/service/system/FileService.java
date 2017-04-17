package com.ref.service.system;

import com.ref.base.exception.BusinessException;
import com.ref.model.system.File;

import java.util.List;

public interface FileService {

   File saveFile(File file) throws BusinessException;

   List<File> getFile(Long relationId, String relationType) throws BusinessException;

   void delete(Long id, Long userId) throws BusinessException;


}
