package br.mission.andromeda.M.A.Todo.List.repository;

import br.mission.andromeda.M.A.Todo.List.models.TarefaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaModel,Long> {
}
