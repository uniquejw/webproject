package webproject.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webproject.web.dao.ContactDao;
import webproject.web.domain.Contact;
import webproject.web.domain.ContactTel;
import webproject.web.service.ContactService;

@Service
public class DefaultContactService implements ContactService {

	@Autowired
	ContactDao contactDao;

	@Override
	public int add(Contact contact) {
		contactDao.insert(contact);
		for (ContactTel tel : contact.getTels()) {
			tel.setContactNo(contact.getNo()); // 전화번호 입력 전에 자동 생성된 연락처 번호를 설정한다.
			contactDao.insertTel(tel);
		}
		return 1;
	}
	@Override
	public List<Contact> list() {
		List<Contact> contacts = contactDao.findAll();
		for (Contact contact : contacts) {
			contact.setTels(contactDao.findTelByContactNo(contact.getNo()));
		}
		return contacts;
	}
	@Override
	public Contact get(int no) {
		Contact contact = contactDao.findByNo(no);
		if (contact != null) {
			contact.setTels(contactDao.findTelByContactNo(no));
		}
		return contact;
	}
	@Override
	public int update(Contact contact) {
		int count = contactDao.update(contact);
		if (count > 0) {
			contactDao.deleteTelByContactNo(contact.getNo());
			for (ContactTel tel : contact.getTels()) {
				contactDao.insertTel(tel);
			}
		}
		return count;
	}
	@Override
	public int delete(int no) {
		contactDao.deleteTelByContactNo(no);
		return contactDao.delete(no);
	}
}
