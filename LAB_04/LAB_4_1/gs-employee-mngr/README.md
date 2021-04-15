a) Podemos encontrar um par de exemplos do uso do AssertJ nos seguintes locais:

    1) Classe: EmployeeRepositoryTest.java
       Método: givenSetOfEmployees_whenFindAll_thenReturnAllEmployees()
       AssertJ: assertThat(allEmployees).hasSize(3).extracting(Employee::getName).containsOnly(alex.getName(), ron.getName(), bob.getName())

    2) Classe: EmployeeService_UnitTest.java
       Método: given3Employees_whengetAll_thenReturn3Records()
       AssertJ: assertThat(allEmployees).hasSize(3).extracting(Employee::getName).contains(alex.getName(), john.getName(), bob.getName())

b) Podemos encontrar um exemplo onde queremos Mock o comportamento do repository (e evitar envolver a DataBase) nos seguintes locais:


    1) Classe: EmployeeService_UnitTest.java
       Método: setUp()
       Mock: Mockito.when(employeeRepository.findByName(john.getName())).thenReturn(john)
             Mockito.when(employeeRepository.findByName(alex.getName())).thenReturn(alex)

c) A diferença entre Mock e MockBean é a seguinte:

    A anotação @Mock é uma anotação utilizada em testes da classe para mock o comportamento de uma certa classe assim conseguimos usar o
    mock stub para retornar um valor para o seus métodos e verificar que eles foram chamados.

    A anotação @MockBean é uma anotação utilizada pelo SpringBoot para adicionar objetos mock para a application context (dependency injection).
    Assim, o mock irá substituir qualquer bean existente do mesmo tipo na application context.
    Esta anotação é útil para integração de testes onde um bean e um serviço externo precisam de ser mocked.

d) O role do ficheiro “application-integrationtest.properties” e as condicções em que é utilizado são:

    O ficheiro define todas as propriedades necessárias para a integração de testes para funcionarem, tal
    como o datasource url, o username, a palavra-passe, entre outros.
    O ficheiro é utilizado pelos testes de integração, para conectar-se a base de dados envolvida nesse teste.


