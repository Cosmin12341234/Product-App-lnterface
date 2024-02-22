package com.example.examen.repository;

import com.example.examen.domain.IEntity;

import java.util.ArrayList;

public abstract class AbstractRepository<T extends IEntity> implements IRepository<T> {

    protected ArrayList<T> entityList = new ArrayList<>();
}
