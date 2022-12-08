package edu.tdtu.huy1.service;

import edu.tdtu.huy1.Exception.NotFoundException;
import edu.tdtu.huy1.entities.Reader;
import edu.tdtu.huy1.entities.Role;
import edu.tdtu.huy1.entities.TypeOfReader;
import edu.tdtu.huy1.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReaderService {
    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void encodePassword(Reader reader) {
        String encodePassword = passwordEncoder.encode(reader.getPassword());
        reader.setPassword(encodePassword);
    }

    public Reader save(Reader reader) {
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
        String currentTime = formatter.format(new Date());
        reader.setIdReader("Reader" + currentTime);
        encodePassword(reader);
        reader.setRole(Role.READER);

        return readerRepository.save(reader);
    }

    public List<Reader> listAllReader(String keyword) {
        List<Reader> readers = new ArrayList<>();
        if (keyword != null) {
            for (Reader reader : readerRepository.findAll(keyword)) {
                if (reader.getRole() == Role.READER)
                    readers.add(reader);
            }
        } else {
            for (Reader reader : readerRepository.findAll()) {
                if (reader.getRole() == Role.READER)
                    readers.add(reader);
            }
        }
        return readers;
    }

    public List<Reader> list4LatestReader() {
        List<Reader> readers = new ArrayList<>();
        int count = 0;
        for (Reader reader : readerRepository.findAll()) {
            if (count == 4)
                break;
            if (reader.getRole() == Role.READER)
                readers.add(reader);
            count++;
        }
        return readers;
    }

    public void deleteReader(String id) throws NotFoundException {
        Long count = readerRepository.countByIdReader(id);
        if (count == null || count == 0) {
            throw new NotFoundException("Could not find any book with id: " + id);
        }
        readerRepository.deleteById(id);
    }

    public Reader findByEmail(String email){
        return  readerRepository.findByEmail(email);
    }
}
