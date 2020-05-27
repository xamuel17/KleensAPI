package com.kleens.db.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kleens.db.uploadImage2.image;

public interface imageRepo extends JpaRepository <image, Long> {

}
