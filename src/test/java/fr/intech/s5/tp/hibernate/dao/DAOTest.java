package fr.intech.s5.tp.hibernate.dao;

import static org.junit.Assert.*;

import org.junit.*;

import fr.intech.s5.tp.hibernate.entity.Client;

public class DAOTest {
	DAO dao;
	
	@Before
	public void setUp() {
		dao = new DAO();
	}
	
	@After
	public void tearDown() {
		dao.close();
	}
	
	@Test
	public void testClient() {
		Client client = new Client();
		
		client.setNom("DeGroot");
		client.setPrenom("Tavish");
		client.setAddresse("42, Merasmus alley");
		client.setCodePostal("75001");
		client.setPassword("AhmDrunkHiiiiGotNoEssCooss");
		client.setVille("Teufort");
		client.setEmail("wait.whatdoiwritehere@saxtonhale.au");
		
		Long idClient = dao.ajout(client);
		Client client1 = dao.getClient(idClient);
		
		assertNotNull(client1);
		assertTrue(idClient > 0);
		assertEquals("DeGroot", client.getNom());
		assertEquals("Tavish", client.getPrenom());
		assertEquals("42, Merasmus alley", client.getAddresse());
		assertEquals("75001", client.getCodePostal());
		assertEquals("AhmDrunkHiiiiGotNoEssCooss", client.getPassword());
		assertEquals("Teufort", client.getVille());
		assertEquals("wait.whatdoiwritehere@saxtonhale.au", client.getEmail());
	}
}
