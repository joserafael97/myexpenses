package br.com.jrafael.myexpenses.domain.repository

import br.com.jrafael.myexpenses.domain.models.Spent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional(Transactional.TxType.MANDATORY)
interface SpentRepository : JpaRepository<Spent, Long>