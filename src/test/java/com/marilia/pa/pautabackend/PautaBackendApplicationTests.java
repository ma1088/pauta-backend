package com.marilia.pa.pautabackend;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.marilia.pa.pautabackend.controller.PautaController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PautaBackendApplicationTests {

	@Autowired
	PautaController pautaController;

	@Test
	void contextLoads() {
		Assertions.assertThatObject(pautaController).isNotNull();
	}

}
