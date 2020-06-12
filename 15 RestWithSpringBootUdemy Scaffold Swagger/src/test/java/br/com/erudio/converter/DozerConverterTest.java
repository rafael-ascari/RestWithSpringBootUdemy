package br.com.erudio.converter;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.erudio.converter.mocks.MockBook;
import br.com.erudio.converter.mocks.MockPerson;
import br.com.erudio.data.model.Book;
import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.data.vo.v1.PersonVO;

public class DozerConverterTest {
	
    MockPerson inputPerson;
    MockBook inputBook;

    @Before
    public void setUp() {
        inputPerson = new MockPerson();
        inputBook = new MockBook();
        
    }

    @Test
    public void parseEntityToVOTest() {
        PersonVO output = DozerConverter.parseObject(inputPerson.mockEntity(), PersonVO.class);
        Assert.assertEquals(Long.valueOf(0L), output.getKey());
        Assert.assertEquals("First Name Test0", output.getFirstName());
        Assert.assertEquals("Last Name Test0", output.getLastName());
        Assert.assertEquals("Addres Test0", output.getAddress());
        Assert.assertEquals("Male", output.getGender());
        
        BookVO bo = DozerConverter.parseObject(inputBook.mockEntity(), BookVO.class);
        Assert.assertEquals(Long.valueOf(0L), bo.getKey());
        Assert.assertEquals("Author0", bo.getAuthor());
        Assert.assertEquals("Title0", bo.getTitle());
        Assert.assertEquals(Double.valueOf(0), bo.getPrice());
        
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PersonVO> outputList = DozerConverter.parseListObjects(inputPerson.mockEntityList(), PersonVO.class);
        PersonVO outputZero = outputList.get(0);
        
        Assert.assertEquals(Long.valueOf(0L), outputZero.getKey());
        Assert.assertEquals("First Name Test0", outputZero.getFirstName());
        Assert.assertEquals("Last Name Test0", outputZero.getLastName());
        Assert.assertEquals("Addres Test0", outputZero.getAddress());
        Assert.assertEquals("Male", outputZero.getGender());
        
        PersonVO outputSeven = outputList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getKey());
        Assert.assertEquals("First Name Test7", outputSeven.getFirstName());
        Assert.assertEquals("Last Name Test7", outputSeven.getLastName());
        Assert.assertEquals("Addres Test7", outputSeven.getAddress());
        Assert.assertEquals("Female", outputSeven.getGender());
        
        PersonVO outputTwelve = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getKey());
        Assert.assertEquals("First Name Test12", outputTwelve.getFirstName());
        Assert.assertEquals("Last Name Test12", outputTwelve.getLastName());
        Assert.assertEquals("Addres Test12", outputTwelve.getAddress());
        Assert.assertEquals("Male", outputTwelve.getGender());

        List<BookVO> olBook = DozerConverter.parseListObjects(inputBook.mockEntityList(), BookVO.class);
        BookVO bo = olBook.get(0);
        Assert.assertEquals(Long.valueOf(0L), bo.getKey());
        Assert.assertEquals("Author0", bo.getAuthor());
        Assert.assertEquals("Title0", bo.getTitle());
        Assert.assertEquals(Double.valueOf(0), bo.getPrice());
        
        bo = olBook.get(7);
        Assert.assertEquals(Long.valueOf(7L), bo.getKey());
        Assert.assertEquals("Author7", bo.getAuthor());
        Assert.assertEquals("Title7", bo.getTitle());
        Assert.assertEquals(Double.valueOf(7), bo.getPrice());        

        bo = olBook.get(12);
        Assert.assertEquals(Long.valueOf(12L), bo.getKey());
        Assert.assertEquals("Author12", bo.getAuthor());
        Assert.assertEquals("Title12", bo.getTitle());
        Assert.assertEquals(Double.valueOf(12), bo.getPrice());        
    
    
    }

    @Test
    public void parseVOToEntityTest() {
        Person output = DozerConverter.parseObject(inputPerson.mockVO(), Person.class);
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("First Name Test0", output.getFirstName());
        Assert.assertEquals("Last Name Test0", output.getLastName());
        Assert.assertEquals("Addres Test0", output.getAddress());
        Assert.assertEquals("Male", output.getGender());
        
        Book bo = DozerConverter.parseObject(inputBook.mockEntity(), Book.class);
        Assert.assertEquals(Long.valueOf(0L), bo.getId());
        Assert.assertEquals("Author0", bo.getAuthor());
        Assert.assertEquals("Title0", bo.getTitle());
        Assert.assertEquals(Double.valueOf(0), bo.getPrice());

    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Person> outputList = DozerConverter.parseListObjects(inputPerson.mockVOList(), Person.class);
        Person outputZero = outputList.get(0);
        
        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("First Name Test0", outputZero.getFirstName());
        Assert.assertEquals("Last Name Test0", outputZero.getLastName());
        Assert.assertEquals("Addres Test0", outputZero.getAddress());
        Assert.assertEquals("Male", outputZero.getGender());
        
        Person outputSeven = outputList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("First Name Test7", outputSeven.getFirstName());
        Assert.assertEquals("Last Name Test7", outputSeven.getLastName());
        Assert.assertEquals("Addres Test7", outputSeven.getAddress());
        Assert.assertEquals("Female", outputSeven.getGender());
        
        Person outputTwelve = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("First Name Test12", outputTwelve.getFirstName());
        Assert.assertEquals("Last Name Test12", outputTwelve.getLastName());
        Assert.assertEquals("Addres Test12", outputTwelve.getAddress());
        Assert.assertEquals("Male", outputTwelve.getGender());
        
        List<Book> olBook = DozerConverter.parseListObjects(inputBook.mockEntityList(), Book.class);
        Book bo = olBook.get(0);
        Assert.assertEquals(Long.valueOf(0L), bo.getId());
        Assert.assertEquals("Author0", bo.getAuthor());
        Assert.assertEquals("Title0", bo.getTitle());
        Assert.assertEquals(Double.valueOf(0), bo.getPrice());
        
        bo = olBook.get(7);
        Assert.assertEquals(Long.valueOf(7L), bo.getId());
        Assert.assertEquals("Author7", bo.getAuthor());
        Assert.assertEquals("Title7", bo.getTitle());
        Assert.assertEquals(Double.valueOf(7), bo.getPrice());        

        bo = olBook.get(12);
        Assert.assertEquals(Long.valueOf(12L), bo.getId());
        Assert.assertEquals("Author12", bo.getAuthor());
        Assert.assertEquals("Title12", bo.getTitle());
        Assert.assertEquals(Double.valueOf(12), bo.getPrice());        
        
    }
}
