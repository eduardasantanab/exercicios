package br.unicap.ed1.atividade02;

public class Solucao {
    int[] nums;

    public Solucao(int[] _nums){
       this.nums = _nums;
    }

    public int numeroFaltando(){
        int resposta = 0;
        int aux;

//        ordena o vetor
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if (nums[j] > nums[i]) {
                    aux = nums[j];
                    nums[j] = nums[i];
                    nums[i] = aux;
                }
            }
        }

//        encontra numero faltante
        for(int i = 0; i < nums.length - 1;i++){
            if(nums[i + 1] - nums[i] > 1){
                resposta = (i+1);
            }
        }
        return resposta;
    }
}