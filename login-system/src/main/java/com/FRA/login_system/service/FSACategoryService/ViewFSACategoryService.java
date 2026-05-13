package com.FRA.login_system.service.FSACategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.FSACategory;
import com.FRA.login_system.repository.FSACategoryRepository;

@Service
public class ViewFSACategoryService {

    @Autowired
    private FSACategoryRepository fsaCategoryRepository;

    public List<FSACategory> getFSACategories() {
        return fsaCategoryRepository.findAll();
    }
}