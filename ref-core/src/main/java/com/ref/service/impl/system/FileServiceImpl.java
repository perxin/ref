package com.ref.service.impl.system;

import com.ref.base.constant.CommonConstant.ErrorCode;
import com.ref.base.exception.BusinessException;
import com.ref.base.util.EntityUtil;
import com.ref.dao.system.FileMapper;
import com.ref.model.system.File;
import com.ref.service.system.FileService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public File saveFile(File file) throws BusinessException {
        if (file.getRelationId() == null || StringUtils.isEmpty(file.getRelationType()) || StringUtils.isEmpty(file.getFileUrl())) {
            throw new BusinessException(ErrorCode.ERROR_CODE_PARAMETER_ILLEGAL);
        }
        EntityUtil.insertBefore(file, file.getCreateBy());
        fileMapper.insertSelective(file);
        return file;
    }

    @Override
    public List<File> getFile(Long relationId, String relationType) throws BusinessException {
        return fileMapper.selectByRelationIdAndType(relationId, relationType);
    }

    @Override
    public void delete(Long id, Long userId) throws BusinessException {
        File file = new File();
        file.setId(id);
        file.setDeleted(true);
        EntityUtil.updateBefore(file, userId);
        fileMapper.updateByPrimaryKeySelective(file);
    }
}
