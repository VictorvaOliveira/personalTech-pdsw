package com.mycompany.tests;

import com.mycompany.personaltech.entities.Aluno;
import com.mycompany.personaltech.entities.Avaliacao;
import com.mycompany.personaltech.entities.Endereco;
import com.mycompany.personaltech.entities.Exercicio;
import com.mycompany.personaltech.entities.MedStatus;
import com.mycompany.personaltech.entities.NomeExercicio;
import com.mycompany.personaltech.entities.PersonalTrainer;
import com.mycompany.personaltech.entities.TipoExercicio;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AlunoTest {

    private static EntityManagerFactory emf;
    private static Logger logger;
    private EntityManager em;
    private EntityTransaction et;

    public AlunoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        logger = Logger.getGlobal();
        logger.setLevel(Level.INFO);
        emf = Persistence.createEntityManagerFactory("PTech_PU");
        DbUnitUtil.inserirDados();
    }

    @AfterClass
    public static void tearDownClass() {
        emf.close();
    }

    @Before
    public void setUp() {
        em = emf.createEntityManager();
        beginTransaction();
    }

    @After
    public void tearDown() {
        commitTransaction();
        em.close();
    }

    private void beginTransaction() {
        et = em.getTransaction();
        et.begin();
    }

    private void commitTransaction() {
        try {
            et.commit();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
            if (et.isActive()) {
                et.rollback();
            }
            fail(ex.getMessage());
        }
    }

    @Test
    public void TEST_01() {
        PersonalTrainer pt = em.find(PersonalTrainer.class, (long) 1);
        int size = pt.getAlunos().size();
        Aluno aluno = pt.getAlunos().get(0);
        pt.removeAluno(aluno);
        int sizeMinusOne = pt.getAlunos().size();
        assertTrue(sizeMinusOne < size);
    }

    @Test
    public void TEST_02() {
        PersonalTrainer pt = em.find(PersonalTrainer.class, (long) 2);
        em.remove(pt);
        em.flush();
        em.clear();
        PersonalTrainer pt2 = em.find(PersonalTrainer.class, (long) 2);
        assertNull(pt2);
    }

    @Test
    public void TEST_03() {
        String jpql = "SELECT p FROM PersonalTrainer p where p.login = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, "CB");
        PersonalTrainer pt = (PersonalTrainer) query.getSingleResult();
        assertEquals("CB", pt.getLogin());
    }

    @Test
    public void inserirAluno_01() {
        Aluno aluno = new Aluno();
        aluno.setNome("ZECA");
        aluno.setSobrenome("CAMARGO");
        aluno.setCpf("23454321123");
        aluno.setTipo("A");
        aluno.setLogin("ZECA");
        aluno.setSenha("ABC");
        aluno.setEmail("ZECAM@RGO");
        aluno.setSexo("M");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2000);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 10);
        aluno.setDataNascimento(cal.getTime());

        Endereco end = new Endereco();
        end.setLogradouro("RUA DO CORDEIRO");
        end.setBairro("CORDEIRO");
        end.setNumero(666);
        end.setCep("123456-88");
        end.setCidade("RECIFE");
        end.setEstado("PERNAMBUCO");
        
        Exercicio ex = new Exercicio();
        ex.setTipo("PEITORAL");
        ex.setExercicio("PEIT_SUP_KINESIS");
        ex.setSerie(3);
        ex.setRepeticao(30);
        ex.setPeso(10);

        aluno.addExercicio(ex);

        aluno.setEndereco(end);
        PersonalTrainer pt = em.find(PersonalTrainer.class, (long) 1); // carlos CB
        pt.addAluno(aluno);
        em.persist(aluno);

        em.flush();
        assertNotNull(aluno.getId());
    }
    
    @Test
    public void inserirAluno_02() {
        Aluno aluno = new Aluno();
        aluno.setNome("BONECO");
        aluno.setSobrenome("JOSIAS");
        aluno.setCpf("23454321666");
        aluno.setTipo("A");
        aluno.setLogin("JOSIAS");
        aluno.setSenha("JOSIAS");
        aluno.setEmail("BONECO@JOSIAS");
        aluno.setSexo("M");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1998);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 10);
        aluno.setDataNascimento(cal.getTime());

        Endereco end = new Endereco();
        end.setLogradouro("RUA DO CORDEIRO");
        end.setBairro("CORDEIRO");
        end.setNumero(666);
        end.setCep("123456-88");
        end.setCidade("RECIFE");
        end.setEstado("PERNAMBUCO");

        aluno.setEndereco(end);
        PersonalTrainer pt = em.find(PersonalTrainer.class, (long) 1);  // carlos CB
        pt.addAluno(aluno);
        em.persist(aluno);

        em.flush();
        assertNotNull(aluno.getId());
    }
    
    @Test
    public void inserirAluno_03() {
        Aluno aluno = new Aluno();
        aluno.setNome("JOHN");
        aluno.setSobrenome("MAYK BRITO");
        aluno.setCpf("23453421123");
        aluno.setTipo("A");
        aluno.setLogin("JOHNLIMA");
        aluno.setSenha("123");
        aluno.setEmail("JOHN@LIMA");
        aluno.setSexo("M");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2000);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 10);
        aluno.setDataNascimento(cal.getTime()); //01/10/2000

        Endereco end = new Endereco();
        end.setLogradouro("RUA DO CORDEIRO");
        end.setBairro("CORDEIRO");
        end.setNumero(666);
        end.setCep("123456-88");
        end.setCidade("RECIFE");
        end.setEstado("PERNAMBUCO");
        aluno.setEndereco(end);
        
        Exercicio ex = new Exercicio();
        ex.setTipo("PEITORAL");
        ex.setExercicio("PEIT_SUP_KINESIS");
        ex.setSerie(3);
        ex.setRepeticao(30);
        ex.setPeso(10);
        aluno.addExercicio(ex);
        
        Avaliacao av = new Avaliacao();
        av.setPeso(78.5);
        av.setAltura(1.7);
        av.setPressaoArtAtual("120/80mmHg");
        av.setObs("Qualquer observação");
        cal.set(Calendar.YEAR, 2000);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 10);
        av.setDataAvaliacao(cal.getTime());
        aluno.addAvaliacao(av);
        
        MedStatus ms = new MedStatus();
        ms.setDiabetes("Tipo_1");
        ms.setProbCardiaco(true);
        ms.setObsProbCardiaco("É um problema sério");
        ms.setProbOsseo(true);
        ms.setObsprobOsseo("É um problema nos ossos");
        ms.setProbPressaoAterial("Hipertensão");
        ms.setObsProbPressaoAterial("É um problema da pesada");
        aluno.setMedStatus(ms);
        

        PersonalTrainer pt = em.find(PersonalTrainer.class, (long) 1); // carlos CB
        pt.addAluno(aluno);
        em.persist(aluno);

        em.flush();
        assertNotNull(aluno.getId());
    }

    @Test
    public void getTotallAlunos_01() {
        String jpql = "SELECT COUNT(a) FROM Aluno a";
        Query query = em.createQuery(jpql);

        Long alunos = (Long) query.getSingleResult();
        System.out.println(alunos);
        assertTrue(alunos > 0);
    }

    @Test
    public void getAllAlunos_01() {
        String jpql = "SELECT a FROM Aluno a";
        Query query = em.createQuery(jpql);

        List<Aluno> alunos = (List) query.getResultList();

        System.out.println("ALUNOS:");
        for (Aluno aluno : alunos) {
            logger.log(Level.INFO, "selecionarAlunoPorId: Aluno {0}", aluno.getNome() + " " + aluno.getSobrenome());
        }
        assertTrue(alunos != null);
    }

    @Test
    public void getAllPersonalis_01() {
        String jpql = "SELECT p FROM PersonalTrainer p";
        Query query = em.createQuery(jpql);

        List<PersonalTrainer> personais = (List) query.getResultList();

        System.out.println("Personais:");
        for (PersonalTrainer personal : personais) {
            logger.log(Level.INFO, "selecionarAlunoPorId: PersonalTrainer {0}", personal.getNome() + " " + personal.getSobrenome());
        }
        assertTrue(personais != null);
    }

    @Test
    public void editAluno_01() {
        String jpql = "SELECT a FROM Aluno a where a.login = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, "ALAN");
        Aluno aluno = (Aluno) query.getSingleResult();

        aluno.setLogin("NEWALAN");
        em.persist(aluno);
        em.flush();
        em.clear();

        assertEquals("NEWALAN", aluno.getLogin());
    }

    @Test
    public void addExercicio_01() {
        String jpql = "SELECT a FROM Aluno a where a.login = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, "NEWALAN");
        Aluno aluno = (Aluno) query.getSingleResult();

        Exercicio ex = new Exercicio();
        ex.setTipo("PEITORAL");
        ex.setExercicio("PEIT_SUP_KINESIS");
        ex.setSerie(3);
        ex.setRepeticao(30);
        ex.setPeso(10);

        aluno.addExercicio(ex);
        assertEquals("NEWALAN", aluno.getLogin());

    }

//    @Test
//    public void inserirAluno_02() {
//        Aluno aluno = new Aluno();
//        aluno.setNome("KEN");
//        aluno.setSobrenome("GALINDA");
//        aluno.setCpf("123-321-436-12");
//        aluno.setLogin("KENNYG");
//        aluno.setSenha("123");
//        aluno.setEmail("KENNYH@gmail");
//        aluno.setSexo("F");
////        aluno.addTelefone("111 222 333");
//
//        Exercicio ex = new Exercicio();
//        
//        ex.setExercicio("COXAS_45_STIFF_BARRA");
//        ex.setTipo("COXAS");
//        ex.setSerie(2);
//        ex.setRepeticao(20);
//        ex.setPeso(5);
//        aluno.addExercicio(ex);
//
//        Calendar c = Calendar.getInstance();
//        c.set(Calendar.YEAR, 2000);
//        c.set(Calendar.MONTH, Calendar.AUGUST);
//        c.set(Calendar.DAY_OF_MONTH, 27);
//        aluno.setDataNascimento(c.getTime());
//
//        Endereco end = new Endereco();
//        end.setLogradouro("RUA DO CORDEIRO");
//        end.setBairro("CORDEIRO");
//        end.setNumero(666);
//        end.setCep("123456-88");
//        end.setCidade("RECIFE");
//        end.setEstado("PERNAMBUCO");
//
//        aluno.setEndereco(end);
//
//        em.persist(aluno);
//
//        em.flush();
//        assertNotNull(em.find(Aluno.class, (long) 3));
//    }
//
//    @Test
//    public void atualizarAluno_01() {
//        Aluno aluno = em.find(Aluno.class, (long) 24);
//        assertNotNull(aluno);
//        aluno.setEmail("email@hotmail.com");
//        em.flush();
//        em.clear();
//        logger.log(Level.INFO, "selecionarAlunoPorId: Aluno {0}", aluno.getNome());
//        aluno = em.find(Aluno.class, (long) 24);
//        assertEquals("email@hotmail.com", aluno.getEmail());
//    }
//
//    @Test
//    public void atualizarAluno_02() {
//        Aluno aluno = em.find(Aluno.class, (long) 27);
//        assertNotNull(aluno);
//        aluno.setEmail("email@hotmail.com");
//        em.flush();
//        em.clear();
//        logger.log(Level.INFO, "selecionarAlunoPorId: Aluno {0}", aluno.getNome());
//        aluno = em.find(Aluno.class, (long) 24);
//        assertEquals("email@hotmail.com", aluno.getEmail());
//    }
//
//    @Test
//    public void selecionarAlunoPorCPF_01() {
//        String jpql = "SELECT a FROM Aluno a where a.cpf = ?1";
//        Query query = em.createQuery(jpql);
//        query.setParameter(1, "05842569855");
//
//        Aluno aluno = (Aluno) query.getSingleResult();
//
//        assertEquals("05842569855", aluno.getCpf());
//        logger.log(Level.INFO, "selecionarAlunoPorId: Aluno {0}", aluno.toString());
//    }
//
//    @Test
//    public void selecionarAlunoPorId() {
//        Aluno aluno = em.find(Aluno.class, (long) 29);
//        assertNotNull(aluno);
//        assertEquals("MICHEL", aluno.getNome());
//        String nome = aluno.getNome();
//        assertEquals("05842569855", aluno.getCpf());
//        logger.log(Level.INFO, "selecionarAlunoPorId: Aluno {0}", aluno.toString());
//    }
//
//    @Test
//    public void deletarAluno_01() {
//        Aluno aluno = em.find(Aluno.class, (long) 12);
//        assertNotNull(aluno);
//        em.remove(aluno);
//        em.flush();
//        em.clear();
//        aluno = em.find(Aluno.class, (long) 12);
//        assertNull(aluno);
//    }
//
//    @Test
//    public void deletarAluno_02() {
//        Aluno aluno = em.find(Aluno.class, (long) 36);
//        em.remove(aluno);
//        em.flush();
//        em.clear();
//        assertEquals(null, em.find(Aluno.class, (long) 36));
//    }
//
//    @Test
//    public void selecionarAvaliacoes() {
//        String jpql = "SELECT COUNT(a) FROM Aluno a";
//        Query query = em.createQuery(jpql);
//
//        Long alunos = (Long) query.getSingleResult();
//
//        assertTrue(alunos == 30);
//    }
}
