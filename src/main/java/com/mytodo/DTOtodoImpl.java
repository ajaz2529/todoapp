package com.mytodo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;

import java.time.LocalDate;


import helpers.FactoryHelper;

public class DTOtodoImpl implements DTOtodo {

	@Override
	public void addNote(String title,String des) {
		try (Session session = FactoryHelper.GetFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Note note = new Note();
            note.setTitle(title);
            note.setDescription(des);
            note.setDate(LocalDate.now());
            session.save(note);
            tx.commit();
            session.close();
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
	}







}
