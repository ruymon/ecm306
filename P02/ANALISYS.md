# Análise dos Exercícios — Aula 02

## Exercício 1 — Inicializar vetor int com 0

| N | Tempo Médio (ns) | Op. Aritméticas | Comparações |
|---|---|---|---|
| 10 | 200 | 21 | 11 |
| 50 | 483 | 101 | 51 |
| 100 | 841 | 201 | 101 |
| 500 | 3.908 | 1.001 | 501 |
| 1.000 | 7.783 | 2.001 | 1.001 |
| 5.000 | 36.833 | 10.001 | 5.001 |
| 10.000 | 71.191 | 20.001 | 10.001 |
| 50.000 | 105.766 | 100.001 | 50.001 |
| 100.000 | 340.000 | 200.001 | 100.001 |
| 500.000 | 513.275 | 1.000.001 | 500.001 |

Complexidade: **O(N)**. Operações aritméticas = 2N+1, comparações = N+1. Tempo cresce linearmente com N.

---

## Exercício 2 — Copiar vetor int para outro vetor

| N | Tempo Médio (ns) | Op. Aritméticas | Comparações |
|---|---|---|---|
| 10 | 166 | 21 | 11 |
| 50 | 541 | 101 | 51 |
| 100 | 1.049 | 201 | 101 |
| 500 | 3.733 | 1.001 | 501 |
| 1.000 | 7.399 | 2.001 | 1.001 |
| 5.000 | 41.916 | 10.001 | 5.001 |
| 10.000 | 83.908 | 20.001 | 10.001 |
| 50.000 | 74.775 | 100.001 | 50.001 |
| 100.000 | 130.416 | 200.001 | 100.001 |
| 500.000 | 519.108 | 1.000.001 | 500.001 |

Complexidade: **O(N)**. Mesma contagem de operações do exercício 1 (2N+1 aritméticas, N+1 comparações). Tempos similares, com pequenas variações por conta do acesso a dois vetores em vez de um.

---

## Exercício 3 — Limpar matriz double N×M com -1

| N × M | Tempo Médio (ns) | Op. Aritméticas | Comparações |
|---|---|---|---|
| 10 × 10 | 1.275 | 221 | 121 |
| 50 × 75 | 42.474 | 7.601 | 3.851 |
| 100 × 300 | 231.749 | 60.201 | 30.201 |
| 500 × 200 | 180.717 | 201.001 | 101.001 |
| 1.000 × 1.000 | 1.121.641 | 2.002.001 | 1.002.001 |
| 5.000 × 7.000 | 16.518.374 | 70.010.001 | 35.010.001 |
| 10.000 × 1 | 13.174 | 40.001 | 30.001 |
| 50.000 × 25.000 | Memória insuf. | — | — |
| 100.000 × 100.000 | Memória insuf. | — | — |
| 500.000 × 1.000 | 328.667.325 | 1.001.000.001 | 501.000.001 |

Complexidade: **O(N×M)**. Operações aritméticas = N(2M+1)+N+1, comparações = N(M+1)+N+1. O caso 10.000×1 é muito mais rápido que 500×200 mesmo tendo N maior, pois o total de elementos (N×M) é que define o custo real. Dimensões como 50.000×25.000 e 100.000×100.000 excedem a memória disponível (precisariam de ~10 GB e ~80 GB respectivamente para `double[][]`).

---

## Exercício 4 — Verificar simetria de matriz int N×N

| N | Simétrica? | Tempo Médio (ns) | Op. Aritméticas | Comparações |
|---|---|---|---|---|
| 10 | Sim | 925 | 76 | 111 |
| 50 | Sim | 17.591 | 1.376 | 2.551 |
| 100 | Sim | 62.741 | 5.251 | 10.101 |
| 500 | Sim | 220.266 | 126.251 | 250.501 |
| 1.000 | Sim | 547.566 | 502.501 | 1.001.001 |
| 5.000 | Sim | 40.772.150 | 12.512.501 | 25.005.001 |
| 10.000 | Sim | 170.340.975 | 50.025.001 | 100.010.001 |
| 50.000 | — | Memória insuf. | — | — |
| 100.000 | — | Memória insuf. | — | — |
| 500.000 | — | Memória insuf. | — | — |

Complexidade: **O(N²)**. A verificação compara apenas o triângulo superior (j > i), resultando em ~N(N-1)/2 comparações de elementos. A partir de N=50.000, a alocação de `int[N][N]` excede a memória disponível (~10 GB para N=50.000).

---

## Observações Gerais

- Exercícios 1 e 2 apresentam crescimento linear, confirmando O(N).
- Exercício 3 depende do produto N×M, não de N ou M isoladamente.
- Exercício 4 cresce quadraticamente; o salto de N=5.000 para N=10.000 (~4× no tempo) confirma O(N²).
- Matrizes muito grandes são inviáveis na JVM com heap padrão. Mesmo com `-Xmx4g`, dimensões como 100.000×100.000 são impraticáveis.
- O tempo medido inclui overhead dos contadores de operações, mas não altera a ordem de grandeza.
