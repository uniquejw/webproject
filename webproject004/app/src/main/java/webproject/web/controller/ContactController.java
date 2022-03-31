package webproject.web.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webproject.web.domain.Contact;
import webproject.web.domain.ContactTel;
import webproject.web.service.ContactService;

@RestController
public class ContactController {

	@Autowired
	ContactService contactService;

	@RequestMapping("/contact/list")
	public Object list() {
		return contactService.list();
	}

	@RequestMapping("/contact/add")
	public Object add(Contact contact, String[] tel) throws Exception {
		ArrayList<ContactTel> telList = new ArrayList<>();
		for (int i = 0; i < tel.length; i++) {
			String[] value = tel[i].split("_");
			if (value[1].length() == 0) {
				continue;
			}
			ContactTel contactTel = new ContactTel(contact.getNo(), Integer.parseInt(value[0]), value[1]);
			telList.add(contactTel);
		}
		contact.setTels(telList);
		return contactService.add(contact);
	}

	@RequestMapping("/contact/get")
	public Object get(int no) {
		Contact contact = contactService.get(no);
		if (contact == null) {
			return "";
		}
		return contact;
	}

	@RequestMapping("/contact/update")
	public Object update(Contact contact, String[] tel) throws Exception {
		ArrayList<ContactTel> telList = new ArrayList<>();
		for (int i = 0; i < tel.length; i++) {
			String[] value = tel[i].split(",");
			if (value[1].length() == 0) {
				continue;
			}
			ContactTel contactTel = (new ContactTel(contact.getNo(), Integer.parseInt(value[0]), value[1]));
			telList.add(contactTel);
		}
		contact.setTels(telList);
		return contactService.update(contact);
	}

	@RequestMapping("/contact/delete")
	public Object delete(int no) throws Exception {
		return contactService.delete(no);
	}

}
