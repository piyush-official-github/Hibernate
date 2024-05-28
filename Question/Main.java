package com.Question;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		Question q1 = new Question();
		q1.setQuestionId(121);
		q1.setQuestion("What is java ?");
		
		Answer answer1 = new Answer();
		answer1.setAnswer_id(1212);
		answer1.setAnswer("java is programming language");
		answer1.setQuestion(q1);
		q1.setAnswer(answer1);
		
		

		Question q2 = new Question();
		q2.setQuestionId(125);
		q2.setQuestion("What is kotlin ?");
		
		Answer answer2 = new Answer();
		answer2.setAnswer_id(1215);
		answer2.setAnswer("koltin is android language");
		answer2.setQuestion(q2);
		q2.setAnswer(answer2);
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		s.save(q1);
		s.save(q2);
		s.save(answer1);
		s.save(answer2);
		
		tx.commit();
		
		
		Question que = (Question)s.get(Question.class, 125);
		System.out.println(que.getQuestion());
		System.out.println(que.getAnswer().getAnswer());
		
		s.close();
		factory.close();
	}

}
