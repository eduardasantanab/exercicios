
package br.unicap.ed1.atividade02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class Testes {

	private Random random;
	private int [] nums;
	private int expected;

	@BeforeEach
	public void configurarVariaveis(){
		this.random = new Random(); 

		int size = this.random.nextInt(5)+1;
		int removed = this.random.nextInt(size);
		nums = new int[size];

		for(int i=0; i < size; i++){
			this.nums[i] = i;
		}

		for(int i = removed; i < size; i++){
			this.nums[i] = this.nums[i] + 1;
		}

		embaralhar();
		System.out.println("\nNumero faltando: "+removed);
		this.expected = removed;
	}

	public void embaralhar(){
		Integer[] integerArray = new Integer [this.nums.length];

        for(int i = 0; i < this.nums.length; i++){
            integerArray[i] = this.nums[i];
        }

		List<Integer> intList = Arrays.asList(integerArray);
        Collections.shuffle(intList);
        intList.toArray(integerArray);

		for(int i = 0; i < this.nums.length; i++){
            this.nums[i] = integerArray[i];
        }

		System.out.print("nums = {");
        for(int i = 0; i < this.nums.length; i++){
            System.out.print(" "+this.nums[i]);
        }
        System.out.print(" }");
	}

	@Test
	public void testarSolucao() {
		Solucao s = new Solucao(this.nums);
		int actual = s.numeroFaltando();
		assertEquals(this.expected, actual);
	}

}