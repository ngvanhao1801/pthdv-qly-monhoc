package hunre.it.subject.controller;

import hunre.it.subject.entity.Subject;
import hunre.it.subject.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class SubjectController {

	@Autowired
	private SubjectRepository subjectRepository;

	@GetMapping("/subjects")
	public List<Subject> getAllSubject() {
		return subjectRepository.findAll();
	}

	@GetMapping("/subjects/{id}")
	public ResponseEntity<Subject> getSubjectById(@PathVariable Long id) {
		Optional<Subject> subjectOptional = subjectRepository.findById(id);
		if (subjectOptional.isPresent()) {
			return ResponseEntity.ok(subjectOptional.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/subjects")
	public Subject createSubject(@RequestBody Subject subject) {
		return subjectRepository.save(subject);
	}

	@PutMapping("/subjects/{id}")
	public ResponseEntity<Subject> updateMonHoc(@PathVariable Long id, @RequestBody Subject subjectDetails) {
		Optional<Subject> subjectOptional = subjectRepository.findById(id);
		if (subjectOptional.isPresent()) {
			Subject subject = subjectOptional.get();
			subject.setMaMonHoc(subjectDetails.getMaMonHoc());
			subject.setTenMonHoc(subjectDetails.getTenMonHoc());
			subject.setLoaiMonHoc(subjectDetails.getLoaiMonHoc());
			subject.setKyGiangDay(subjectDetails.getKyGiangDay());

			return ResponseEntity.ok(subjectRepository.save(subject));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/subjects/{id}")
	public ResponseEntity<Void> deleteMonHoc(@PathVariable Long id) {
		Optional<Subject> subjectOptional = subjectRepository.findById(id);
		if (subjectOptional.isPresent()) {
			subjectRepository.delete(subjectOptional.get());
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
