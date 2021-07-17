package com.cg.homeloan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.homeloan.entities.Admin;
import com.cg.homeloan.repositories.IAdminRepository;
import com.cg.homeloan.services.AdminService;

@SpringBootTest
class AdminServiceTest {

	public static Admin admin, admin1, admin2;

	@BeforeAll
	public static void setUp() {
		admin = new Admin();
		admin1 = new Admin();
		admin2 = new Admin();
		
		admin.setUserId(1);
		admin.setAdminName("asddf");
		admin.setAdminContact("554");
		admin.setPassword("Saishf@");
		admin.setUsername("om");
		
		admin1.setAdminName("asd");
		admin1.setAdminContact("s7");
		admin1.setPassword("jshs@1");
		admin1.setUsername("bcx");
		
		admin2.setAdminName("qwe");
		admin2.setAdminContact("tyu");
		admin2.setPassword("uio@1");
		admin2.setUsername("mjk");
	}

	@Autowired
	AdminService adminService;

	@MockBean
	IAdminRepository adminRepository;

	@Test
	@DisplayName("positive test case of add admin")
	void testAddAdminValidTest() throws Exception {
		when(adminRepository.save(admin)).thenReturn(admin);
		assertEquals(admin, adminService.addAdmin(admin));

	}

	@Test
	@DisplayName("negative test case of add admin")
	void testAddAdminNotValidTest() throws Exception {
		when(adminRepository.save(admin)).thenReturn(admin);
		assertNotEquals(admin1, adminService.addAdmin(admin));
	}

	@Test
	@DisplayName("positive test case for get admin")
	void testGetAdminPositive() throws Exception {
		when(adminRepository.findById(1)).thenReturn(Optional.of(admin1));
		admin = adminService.getAdmin(1);
		assertEquals(admin1.toString(), admin.toString());

	}

	@Test
	@DisplayName("negative test case for get admin")
	void testGetAdminNegative() throws Exception {
		when(adminRepository.findById(2)).thenReturn(Optional.of(admin1));
		admin = adminService.getAdmin(2);
		assertNotEquals(admin2.toString(), admin.toString());

	}

	@Test
	@DisplayName("positive test case of get all admin")
	void testGetAllAdminive() throws Exception {
		List<Admin> list = new ArrayList<>();
		list.add(admin1);
		list.add(admin2);
		adminService.getAllAdmin();
		when(adminRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), adminService.getAllAdmin().size());
	}

	@Test
	@DisplayName("negative test case of get all admin")
	void testGetAllAdminNegative() throws Exception {
		List<Admin> list = new ArrayList<>();
		list.add(admin1);
		list.add(admin2);
		adminService.getAllAdmin();
		when(adminRepository.findAll()).thenReturn(list);
		assertNotEquals(3, adminService.getAllAdmin().size());
	}

	@Test
	@DisplayName("Positive Test case for Validate Admin")
	public void testValidAdminPositive() {
		Admin expected = new Admin("1234567890", "admin", "12345", 1, "admin@123");
		when(adminRepository.findByUsernameAndPassword("admin@123", "12345")).thenReturn(expected);
		boolean val = adminService.isValidAdmin("admin@123", "12345");
		assertEquals(val, true);
	}

	@Test
	@DisplayName("Negative Test case for Validate Admin")
	public void testValidAdminNegative() {
		Admin expected = new Admin("1234567890", "admin", "12345", 1, "admin@123");
		when(adminRepository.findByUsernameAndPassword("admin@123", "12345")).thenReturn(expected);
		boolean val = adminService.isValidAdmin("admin@123", "1234");
		assertNotEquals(val, true);
	}

}
