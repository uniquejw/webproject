package webproject.web.service;

import java.util.List;

import webproject.web.domain.Contact;

public interface ContactService {

  int add(Contact contact);

  List<Contact> list();

  Contact get(int no);

  int update(Contact contact);

  int delete(int no);
}
