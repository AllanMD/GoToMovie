package com.metodologia.gotomovie.repository;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Connection;
// para el error del time del server:  SET GLOBAL time_zone = '+3:00';
@Data
@AllArgsConstructor
public abstract class BaseRepository {
    Connection connection;
}
