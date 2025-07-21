# Entrevista Técnica - Java Senior 🚀

## 👋 Bem-vindo(a)!

Olá! Ficamos muito felizes que você chegou até esta etapa do nosso processo seletivo. Esta entrevista técnica foi desenhada para conhecermos melhor suas habilidades como desenvolvedor(a) Java Senior e, principalmente, sua forma de pensar e resolver problemas.

## 📋 Contexto da Entrevista

Este é um projeto Spring Boot com uma API REST simples para gerenciamento de pedidos (orders). Imagine que este código foi desenvolvido rapidamente por um time junior e agora precisa do seu olhar experiente para identificar melhorias e problemas antes de ir para produção.

**Não se preocupe!** Os problemas foram colocados intencionalmente para avaliarmos sua capacidade de análise e conhecimento técnico. Não é um teste de "pegadinha" - é uma oportunidade para você mostrar sua expertise.

## 🎯 Objetivo da Avaliação

Durante nossa conversa, você irá:
1. **Executar o projeto** e testar os endpoints (familiarização)
2. **Fazer um code review** identificando problemas e melhorias
3. **Discutir soluções** para os problemas encontrados
4. **Conversar sobre conceitos** técnicos relacionados

## 💪 O que Esperamos (e o que NÃO esperamos)

### ✅ **Esperamos:**
- **Pensamento crítico**: Identifique problemas reais que impactariam produção
- **Soluções práticas**: Não apenas "o que está errado", mas "como resolver"
- **Justificativas técnicas**: Explique o "porquê" das suas sugestões
- **Consideração de trade-offs**: Toda solução tem prós e contras
- **Experiência compartilhada**: Conte sobre situações similares que já viveu

### ❌ **NÃO esperamos:**
- **Código perfeito**: Não é sobre decorar syntax
- **Respostas decoradas**: Queremos ver seu processo de raciocínio
- **Identificar TODOS os problemas**: Foque nos mais importantes
- **Nervosismo**: É uma conversa técnica entre profissionais

## 💡 Conselhos para o Sucesso

### 🧠 **Mindset Vencedor**
- **Seja você mesmo**: Sua experiência única é valiosa
- **Pense em voz alta**: Compartilhe seu processo de raciocínio conosco
- **Faça perguntas**: Se algo não estiver claro, pergunte! Isso demonstra maturidade
- **Relate experiências**: "Já vi isso antes em...", "Em um projeto anterior..."
- **Não tenha pressa**: Prefira uma análise cuidadosa a respostas apressadas

### 🔍 **Estratégia de Análise**
1. **Primeiro execute**: Veja o que funciona antes de criticar
2. **Priorize impactos**: Foque primeiro nos problemas que quebrariam produção
3. **Pense no futuro**: Como esse código se comportaria com 10x mais usuários?
4. **Considere o time**: Como outros desenvolvedores trabalhariam neste código?

### 🚀 **Lembre-se:**
> **Não existe uma única resposta certa!** Queremos conhecer sua forma de pensar, suas experiências passadas e como você abordaria os desafios. Cada desenvolvedor senior traz perspectivas únicas - mostre a sua!

---

### Pré-requisitos
- Java 17+
- Maven 3.6+

### Executando a Aplicação

```bash
# 1. Clone ou extraia o projeto
cd java-interview-senior

# 2. Compile o projeto
mvn clean compile

# 3. Execute a aplicação
mvn spring-boot:run

# A aplicação estará disponível em: http://localhost:8080
```

### Testando os Endpoints

#### 1. Listar todos os pedidos
```bash
curl -X GET http://localhost:8080/orders
```

#### 2. Buscar pedido por ID
```bash
curl -X GET http://localhost:8080/orders/1
```

#### 3. Criar um novo pedido
```bash
curl -X POST http://localhost:8080/orders \
  -H "Content-Type: application/json" \
  -d '{
    "customerEmail": "novo@cliente.com",
    "items": [
      {
        "productName": "Produto Teste",
        "price": 99.99,
        "quantity": 2
      },
      {
        "productName": "Produto Teste 2",
        "price": 150.00,
        "quantity": 1
      }
    ]
  }'
```

#### 4. Cancelar um pedido
```bash
curl -X POST http://localhost:8080/orders/1/cancel
```

#### 5. Deletar um pedido
```bash
curl -X DELETE http://localhost:8080/orders/1
```

## 🏗️ Arquitetura do Projeto

```
src/main/java/br/com/zup/java/
├── Application.java                    # Classe principal
├── controller/
│   └── OrderController.java           # REST Controller
├── usecase/
│   ├── CreateOrderUseCase.java        # Caso de uso para criação
│   └── GetOrderUseCase.java           # Caso de uso para consultas
├── entity/
│   ├── Order.java                     # Entidade principal
│   └── OrderItem.java                 # Itens do pedido
├── port/
│   └── OrderRepositoryPort.java       # Interface de domínio
├── adapter/
│   └── OrderRepositoryAdapter.java    # Implementação da interface
├── repository/
│   └── OrderRepository.java           # Repository JPA
└── service/
    └── OrderService.java              # Service (legado)
```

## 💾 Banco de Dados

O projeto usa **SQLite** como banco de dados para simplicidade:
- Arquivo: `orders.db` (criado automaticamente)
- Dados iniciais carregados via `data.sql`
- Schema criado automaticamente pelo Hibernate

### Estrutura das Tabelas

**orders**
- id (Long, PK, Auto increment)
- customer_email (String)
- total (BigDecimal)
- status (String)
- created_at (LocalDateTime)

**order_items**
- id (Long, PK, Auto increment)
- order_id (Long, FK)
- product_name (String)
- price (BigDecimal)
- quantity (Integer)

## 📝 O que Esperamos de Você

## 📝 Áreas de Avaliação Principais

### 🏗️ **Arquitetura e Design**
- **Clean Architecture**: Separação de responsabilidades, inversão de dependência
- **Design Patterns**: Identificação e aplicação adequada
- **Acoplamento**: Entre camadas e componentes
- **Organização**: Estrutura de código e nomenclaturas

### ⚡ **Performance e Otimização**
- **Consultas JPA**: Eficiência e problemas como N+1
- **Transações**: Gerenciamento adequado e isolamento
- **Caching**: Oportunidades de otimização
- **Escalabilidade**: Como o código se comporta sob carga

### 🔒 **Segurança e Boas Práticas**
- **Validações**: Input/output, regras de negócio
- **Tratamento de erros**: Exceptions e casos extremos
- **Exposição de dados**: API design e encapsulamento
- **Configurações**: Segurança de credenciais e ambientes

### 💻 **Qualidade de Código**
- **Spring Framework**: Uso adequado de annotations e patterns
- **JPA/Hibernate**: Relacionamentos e configurações
- **Testes**: Estratégias de teste (mesmo que não implementados)
- **Manutenibilidade**: Facilidade de evolução e debugging

---

### Esteja Preparado para Discutir:

1. **Problemas críticos** que você identificou e suas prioridades
2. **Soluções técnicas** com justificativas e alternativas
3. **Experiências passadas** com problemas similares
4. **Trade-offs** das suas propostas (benefícios vs custos)
5. **Conceitos fundamentais**: Transações, ACID, isolamento
6. **Boas práticas** de arquitetura e Spring Boot
7. **Sua visão** sobre como evoluir este sistema

## 🕐 Cronograma da Entrevista

- **5-10 min**: Apresentação e setup
- **10-15 min**: Execução e exploração do projeto
- **25-30 min**: Code review e identificação de problemas
- **20-25 min**: Discussão de soluções e conceitos
- **5-10 min**: Perguntas e próximos passos

**Total**: ~60-90 minutos de conversa técnica construtiva

## 💡 Dicas

1. **Execute primeiro**: Teste os endpoints para entender o comportamento
2. **Pense como senior**: Identifique problemas que impactariam produção
3. **Seja específico**: Aponte não apenas o problema, mas a solução
4. **Considere o contexto**: Pense em escalabilidade, manutenibilidade e performance

## ❓ Dúvidas Técnicas

Se houver problemas para executar o projeto:

1. **Verifique Java 17+**: `java -version`
2. **Verifique Maven**: `mvn -version`
3. **Limpe o projeto**: `mvn clean`
4. **Problemas com SQLite**: O driver é incluído automaticamente

## 🌟 Mensagem Final

**Você chegou até aqui por mérito próprio!** Sua experiência e conhecimento técnico já foram reconhecidos. Esta entrevista é uma oportunidade para demonstrarmos mutuamente se há fit entre suas habilidades e nossos desafios técnicos.

**Relaxe e seja autêntico(a).** Não existem "pegadinhas" ou truques. Queremos conhecer:
- Como você pensa e resolve problemas
- Sua experiência prática com tecnologias
- Sua capacidade de comunicar ideias técnicas
- Seu potencial para crescer conosco

### 🎯 **Lembre-se:**
- **Suas dúvidas são bem-vindas** - demonstram engajamento
- **Experiências passadas são valiosas** - compartilhe suas histórias
- **Não precisa ser perfeito** - buscamos potencial e fit cultural
- **É uma via de duas mãos** - você também está nos avaliando!

---

**Estamos ansiosos para nossa conversa! 💙**

*Boa sorte e que seja uma experiência enriquecedora para todos nós!*

---

## 📞 Contato

Se tiver qualquer dificuldade técnica para executar o projeto ou dúvidas sobre o processo, não hesite em entrar em contato conosco antes da entrevista.

**Vamos juntos construir algo incrível! 🚀**