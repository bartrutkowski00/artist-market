package com.am.user_service.domain.dto;

import java.util.Date;

public record FilterDTO(String username, String email, String city, Date createdDateFrom, Date createdDateTo) {
}
