/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcrf.dao;

import java.util.List;

/**
 *
 * @author jcrfm
 * @param <T>
 */
public interface DaoInterface<T> {
    
        public void insert(T obj);
	
	public void update(T obj);

	public void remove(T obj);

	public T procura(T obj,Long id);
                       
        List<T> findall(T obj);
}
