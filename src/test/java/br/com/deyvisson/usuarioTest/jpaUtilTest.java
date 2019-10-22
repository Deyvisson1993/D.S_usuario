package br.com.deyvisson.usuarioTest;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.deyvisson.util.JpaUtil;


public class jpaUtilTest {
	
	@Test
	public void conectar() {
		
		EntityManager em = JpaUtil.getInstance().getEm();
		em.close();
		
	}

}
