package com.FRA.login_system.service.FSACategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.FSACategory;
import com.FRA.login_system.repository.FSACategoryRepository;

@Service
public class CreateFSACategoryService {

    @Autowired
    private FSACategoryRepository fsaCategoryRepository;

    public String createFSACat(String catName, String catDesc) {
        if (catName == null || catName.isEmpty()) {
            return "Failed to create FSA Category. Please check and try again.";
        }

        FSACategory existing = fsaCategoryRepository.findByCatName(catName);

        if (existing != null) {
            return "FSA Category already exists.";
        }

        FSACategory category = new FSACategory();

        String result = category.createFSACat(catName, catDesc);

        fsaCategoryRepository.save(category);

        return result;
    }
}