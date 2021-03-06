/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Repositories;

import App.Model.Player;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author espin
 */
public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query(
    value="SELECT * FROM player AS i WHERE i.name LIKE %?1%",
            nativeQuery=true)
    public List<Player> getByName(String name);
    
    @Query(
    value="SELECT * FROM player AS i WHERE i.email LIKE ?1 and i.password LIKE ?2",
            nativeQuery=true)
    public Player searchCount(String email, String password);
    
     @Query(
    value="SELECT * FROM player AS i WHERE i.email LIKE ?1",
            nativeQuery=true)
     public Player searchEmail(String email);
}
