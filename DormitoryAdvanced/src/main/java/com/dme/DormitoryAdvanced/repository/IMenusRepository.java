package com.dme.DormitoryAdvanced.repository;

import com.dme.DormitoryAdvanced.entity.Menus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMenusRepository extends JpaRepository<Menus,Long> {
}
