package com.am.user_service.repositories.cstm;

import com.am.user_service.domain.dto.FilterDTO;
import com.am.user_service.domain.entities.UsrEntity;

import java.util.Date;
import java.util.List;

public interface UsrRepositoryCstm {
   List<UsrEntity> findUsers(FilterDTO filterDTO);
}
