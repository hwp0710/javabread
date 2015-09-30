package com.fengjr.crm.dao.mapper;

import com.fengjr.crm.model.db.UserPoints;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPointsMapper {

    @Select(" SELECT " +
            "   id_c AS userId," +
            "   total_points_c AS totalPoints," +
            "   upgrade_points_c AS upgradePoints," +
            "   available_points_c AS availablePoints," +
            "   level_level_c AS level," +
            "   level_name_c AS levelName," +
            "   points_expired_time_c AS expiredTime," +
            "   points_status_c AS status," +
            "   points_description_c AS comments," +
            "   is_permanent_c AS permanentDiamondUser," +
            "   points_date_entered_c AS createTime," +
            "   points_date_modified_c AS updateTime " +
            " FROM " +
            "   contacts_cstm ;")
    List<UserPoints> select(@Param("id") String id);

    @Select(" SELECT " +
            "   id_c AS userId," +
            "   total_points_c AS totalPoints," +
            "   upgrade_points_c AS upgradePoints," +
            "   available_points_c AS availablePoints," +
            "   level_level_c AS level," +
            "   level_name_c AS levelName," +
            "   points_expired_time_c AS expiredTime," +
            "   points_status_c AS status," +
            "   points_description_c AS comments," +
            "   is_permanent_c AS permanentDiamondUser," +
            "   points_date_entered_c AS createTime," +
            "   points_date_modified_c AS updateTime " +
            " FROM " +
            "   contacts_cstm " +
            " WHERE id_c = #{userId} ;")
    UserPoints selectObject(@Param("userId") String userId);

    @Insert(" INSERT INTO contacts_cstm (" +
            "   id_c," +
            "   total_points_c," +
            "   upgrade_points_c," +
            "   available_points_c," +
            "   level_level_c," +
            "   level_name_c," +
            "   points_expired_time_c," +
            "   points_status_c," +
            "   points_description_c," +
            "   is_permanent_c," +
            "   points_date_entered_c," +
            "   points_date_modified_c" +
            " ) " +
            " VALUES " +
            " ( " +
            "   #{userId}," +
            "   #{totalPoints}," +
            "   #{upgradePoints}," +
            "   #{availablePoints}," +
            "   #{level}," +
            "   #{levelName}," +
            "   #{expiredTime}," +
            "   #{status}," +
            "   #{comments}," +
            "   #{permanentDiamondUser}," +
            "   #{createTime}," +
            "   #{updateTime}) ;")
    int add(UserPoints userPoints);

    @Update(" UPDATE " +
            "   contacts_cstm " +
            " SET" +
            "   total_points_c = #{totalPoints}," +
            "   upgrade_points_c = #{upgradePoints}," +
            "   available_points_c = #{availablePoints}," +
            "   level_level_c = #{level}," +
            "   level_name_c = #{levelName}," +
            "   points_expired_time_c = #{expiredTime}," +
            "   points_status_c = #{status}," +
            "   points_description_c = #{comments}," +
            "   is_permanent_c = #{permanentDiamondUser}," +
            "   points_date_modified_c = #{updateTime} " +
            " WHERE id_c = #{userId} ;")
    int update(UserPoints userPoints);

}