package com.friendbooks.friendsservice.dao;

import com.friendbooks.friendsservice.dto.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.friendbooks.friendsservice.entity.FriendEntity;

import java.util.List;

@Repository
public interface FriendDAO extends JpaRepository<FriendEntity, Long> {

    List<FriendEntity> findAllByStatus(String status);

    FriendEntity findByFromEmailAndToEmail(String fromEmail, String toEmail);
}
