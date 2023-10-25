package hunre.it.subject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "mon_hoc")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ma_mon_hoc", nullable = false)
	private String maMonHoc;

	@Column(name = "ten_mon_hoc", nullable = false)
	private String tenMonHoc;

	@Column(name = "loai_mon_hoc", nullable = false)
	@Enumerated(EnumType.STRING)
	private LoaiMonHoc loaiMonHoc;

	@Column(name = "ky_giang_day", nullable = false)
	@Min(1)
	@Max(7)
	private Integer kyGiangDay;

}
