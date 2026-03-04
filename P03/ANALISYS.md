# Análise dos Exercícios — Aula 03 (Modelos de Knuth)

---

## Exercício 1 — Inicializar vetor int com 0

### Algoritmo

```java
for (int i = 0; i < N; i++) {   // Linhas 1-3
    vetor[i] = 0;                // Linha 4
}
```

### Modelo Detalhado

| Linha | Operação | Custo | Frequência |
|-------|----------|-------|------------|
| 1 | `i = 0` | c1 | 1 |
| 2 | `i < N` | c2 | N + 1 |
| 3 | `i++` | c3 | N |
| 4 | `vetor[i] = 0` | c4 | N |

**T(N) = c1 + c2(N+1) + c3·N + c4·N**

Com custos unitários: **T(N) = 3N + 2**

| N | T(N) |
|---|------|
| 10 | 32 |
| 50 | 152 |
| 100 | 302 |
| 500 | 1.502 |
| 1.000 | 3.002 |
| 5.000 | 15.002 |
| 10.000 | 30.002 |
| 50.000 | 150.002 |
| 100.000 | 300.002 |
| 500.000 | 1.500.002 |

### Modelo Simplificado

**T(N) = O(N)** — crescimento linear.

---

## Exercício 2 — Copiar vetor int para outro vetor

### Algoritmo

```java
for (int i = 0; i < N; i++) {       // Linhas 1-3
    destino[i] = origem[i];          // Linha 4
}
```

### Modelo Detalhado

| Linha | Operação | Custo | Frequência |
|-------|----------|-------|------------|
| 1 | `i = 0` | c1 | 1 |
| 2 | `i < N` | c2 | N + 1 |
| 3 | `i++` | c3 | N |
| 4 | `destino[i] = origem[i]` | c4 | N |

**T(N) = c1 + c2(N+1) + c3·N + c4·N**

Com custos unitários: **T(N) = 3N + 2**

| N | T(N) |
|---|------|
| 10 | 32 |
| 50 | 152 |
| 100 | 302 |
| 500 | 1.502 |
| 1.000 | 3.002 |
| 5.000 | 15.002 |
| 10.000 | 30.002 |
| 50.000 | 150.002 |
| 100.000 | 300.002 |
| 500.000 | 1.500.002 |

### Modelo Simplificado

**T(N) = O(N)** — mesma estrutura e complexidade do exercício 1.

---

## Exercício 3 — Limpar matriz double N×M com -1

### Algoritmo

```java
for (int i = 0; i < N; i++) {           // Linhas 1-3
    for (int j = 0; j < M; j++) {       // Linhas 4-6
        matriz[i][j] = -1;              // Linha 7
    }
}
```

### Modelo Detalhado

| Linha | Operação | Custo | Frequência |
|-------|----------|-------|------------|
| 1 | `i = 0` | c1 | 1 |
| 2 | `i < N` | c2 | N + 1 |
| 3 | `i++` | c3 | N |
| 4 | `j = 0` | c4 | N |
| 5 | `j < M` | c5 | N(M + 1) |
| 6 | `j++` | c6 | NM |
| 7 | `matriz[i][j] = -1` | c7 | NM |

**T(N,M) = c1 + c2(N+1) + c3·N + c4·N + c5·N(M+1) + c6·NM + c7·NM**

Com custos unitários: **T(N,M) = 3NM + 3N + 2**

| N × M | N·M | T(N,M) |
|-------|-----|--------|
| 10 × 10 | 100 | 332 |
| 50 × 75 | 3.750 | 11.402 |
| 100 × 300 | 30.000 | 90.302 |
| 500 × 200 | 100.000 | 301.502 |
| 1.000 × 1.000 | 1.000.000 | 3.003.002 |
| 5.000 × 7.000 | 35.000.000 | 105.015.002 |
| 10.000 × 1 | 10.000 | 60.002 |
| 50.000 × 25.000 | 1.250.000.000 | 3.750.150.002 |
| 100.000 × 100.000 | 10.000.000.000 | 30.000.300.002 |
| 500.000 × 1.000 | 500.000.000 | 1.501.500.002 |

### Modelo Simplificado

**T(N,M) = O(NM)** — o custo é proporcional ao total de elementos da matriz, não a N ou M isoladamente. O caso 10.000×1 (T=60.002) é muito menor que 500×200 (T=301.502) apesar de N maior, pois N·M é que domina.

---

## Exercício 4 — Verificar simetria de matriz int N×N

### Algoritmo

```java
for (int i = 0; i < N; i++) {                   // Linhas 1-3
    for (int j = i + 1; j < N; j++) {            // Linhas 4-6
        if (matriz[i][j] != matriz[j][i]) {      // Linha 7
            return false;
        }
    }
}
return true;
```

### Modelo Detalhado (pior caso — matriz simétrica)

No pior caso a matriz é simétrica, obrigando o algoritmo a percorrer todo o triângulo superior.

| Linha | Operação | Custo | Frequência |
|-------|----------|-------|------------|
| 1 | `i = 0` | c1 | 1 |
| 2 | `i < N` | c2 | N + 1 |
| 3 | `i++` | c3 | N |
| 4 | `j = i + 1` | c4 | N |
| 5 | `j < N` | c5 | N(N+1)/2 |
| 6 | `j++` | c6 | N(N-1)/2 |
| 7 | `matriz[i][j] != matriz[j][i]` | c7 | N(N-1)/2 |

**Frequências do laço interno:**
- `j < N` é testado \(\sum_{i=0}^{N-1}(N-i) = \frac{N(N+1)}{2}\) vezes
- `j++` e a comparação de simetria executam \(\sum_{i=0}^{N-1}(N-1-i) = \frac{N(N-1)}{2}\) vezes

**T(N) = c1 + c2(N+1) + c3·N + c4·N + c5·N(N+1)/2 + c6·N(N-1)/2 + c7·N(N-1)/2**

Com custos unitários:

**T(N) = 3N²/2 + 5N/2 + 2**

| N | T(N) |
|---|------|
| 10 | 177 |
| 50 | 3.877 |
| 100 | 15.252 |
| 500 | 376.252 |
| 1.000 | 1.502.502 |
| 5.000 | 37.512.502 |
| 10.000 | 150.025.002 |
| 50.000 | 3.750.125.002 |
| 100.000 | 15.000.250.002 |
| 500.000 | 375.001.250.002 |

### Melhor caso

A matriz não é simétrica e a diferença está em `[0][1]` vs `[1][0]`. O algoritmo sai imediatamente:

**T_melhor(N) = 7** (constante, independente de N).

### Modelo Simplificado

**T(N) = O(N²)** — o termo dominante é 3N²/2. A cada vez que N dobra, T(N) quadruplica.

---

## Comparação entre Modelos

| Exercício | Detalhado | Simplificado |
|-----------|-----------|--------------|
| 1 — Inicializar vetor | 3N + 2 | O(N) |
| 2 — Copiar vetor | 3N + 2 | O(N) |
| 3 — Limpar matriz | 3NM + 3N + 2 | O(NM) |
| 4 — Verificar simetria | 3N²/2 + 5N/2 + 2 | O(N²) |

O modelo detalhado fornece a contagem exata de operações. O modelo simplificado descarta constantes e termos de menor ordem, preservando apenas a taxa de crescimento assintótico.
