package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.dao.ITeacherDAO;
import gr.aueb.cf.schoolapp.dao.exceptions.TeacherDAOException;
import gr.aueb.cf.schoolapp.dto.TeacherInsertDTO;
import gr.aueb.cf.schoolapp.dto.TeacherReadOnlyDTO;
import gr.aueb.cf.schoolapp.dto.TeacherUpdateDTO;
import gr.aueb.cf.schoolapp.exceptions.TeacherAlreadyExistsException;
import gr.aueb.cf.schoolapp.exceptions.TeacherNotFoundException;
import gr.aueb.cf.schoolapp.mapper.Mapper;
import gr.aueb.cf.schoolapp.model.Teacher;

import java.util.List;

public class TeacherServiceImpl implements ITeacherService{

    private final ITeacherDAO teacherDAO;

    public TeacherServiceImpl(ITeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    public TeacherReadOnlyDTO insertTeacher(TeacherInsertDTO dto) throws TeacherDAOException, TeacherAlreadyExistsException {
        Teacher teacher;
        Teacher insertedTeacher;

        try {
            teacher = Mapper.mapTeacherInsertToModel(dto);
            if (teacherDAO.getTeacherByVat(dto.getVat()) != null) throw new
                    TeacherAlreadyExistsException("Teacher with vat: " + dto.getVat() + " already exists");

            insertedTeacher = teacherDAO.insert(teacher);
            // logging
            return Mapper
                    .mapTeacherToReadOnlyDTO(insertedTeacher)
                    .orElseThrow(() -> new TeacherDAOException("Error in Mapping"));
        } catch (TeacherDAOException | TeacherAlreadyExistsException e) {
            // logging
            // rollback
            throw e;
        }
    }

    @Override
    public TeacherReadOnlyDTO updateTeacher(Integer id, TeacherUpdateDTO dto)
            throws TeacherDAOException, TeacherAlreadyExistsException, TeacherNotFoundException {

        Teacher teacher;
        Teacher fetchedTeacher;
        Teacher updatedTeacher;

        try {
            if (teacherDAO.getById(id) == null) {
                throw new TeacherNotFoundException("Teacher with id: " + id + " not found");
            }

            fetchedTeacher = teacherDAO.getTeacherByVat(dto.getVat());
            if (fetchedTeacher != null && !fetchedTeacher.getId().equals(dto.getId())) {
                throw new TeacherAlreadyExistsException("Teacher with id: " + id + " already exists");
            }

            teacher = Mapper.mapTeacherUpdateToModel(dto);
            updatedTeacher = teacherDAO.update(teacher);
            // logging
            return Mapper.mapTeacherToReadOnlyDTO(updatedTeacher).orElseThrow(() -> new TeacherDAOException("Error during mapping"));
        } catch (TeacherDAOException | TeacherAlreadyExistsException | TeacherNotFoundException e) {
            // logging
            // rollback
            throw e;
        }
    }

    @Override
    public void deleteTeacher(Integer id) throws TeacherDAOException, TeacherNotFoundException {
        try {
            if (teacherDAO.getById(id) == null) {
                throw new TeacherNotFoundException("Teacher with id: " + id + " not found");
            }
            // logging
            teacherDAO.delete(id);
        } catch (TeacherDAOException | TeacherNotFoundException e) {
            e.printStackTrace();
            // logging
            // rollback
            throw e;
        }
    }

    @Override
    public TeacherReadOnlyDTO getTeacherById(Integer id) throws TeacherDAOException, TeacherNotFoundException {
        return null;
    }

    @Override
    public List<TeacherReadOnlyDTO> getAllTeachers() throws TeacherDAOException {
        return List.of();
    }

    @Override
    public List<TeacherReadOnlyDTO> getTeacherByLastName(String lastname) throws TeacherDAOException {
        return List.of();
    }
}
