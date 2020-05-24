/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

import java.util.ArrayList;

/**
 *
 * @author juanfrandm98
 */
public class Jugador {
    
    private String username;
    private String password;
    private Personaje personaje;
    private int record;
    private int combateActual;
    private int oro;
    private Arma equipada;
    private Armadura  armadura;
    private Accesorio accesorio;
    private Combate combate;
    
    private ArrayList<Arma> armas =  new ArrayList();
    private ArrayList<Armadura> armaduras =  new ArrayList();
    private ArrayList<Accesorio> accesorios = new ArrayList();
    
    private int indexofHerramienta(String tipo , String nombre){
        boolean paro = false;
        int index = -1;
        if(tipo.equals("arma")){
            for(int i = 0; i < armas.size() && !paro; i++){
                if(armas.get(i).getNombreArma().equals(nombre)){
                    paro = true;
                    index= i;
                }
            }
        }else if(tipo.equals("armadura")){
              for(int i = 0; i < armaduras.size() && !paro; i++){
                if(armaduras.get(i).getNombre().equals(nombre)){
                    paro = true;
                    index= i;
                }
              }
        }else if( tipo.equals( "accesorio" ) ) {
            for( int i = 0; i < accesorios.size() && !paro; i++ ) {
                if( accesorios.get(i).getNombreAccesorio().equals( nombre ) ) {
                    paro = true;
                    index = i;
                }
            }
        }
        
        return index;
    }
    public Jugador( String username, String password ) {
        this.username = username;
        this.password = password;
       
        record = 0;
        combateActual = 0;
        oro = 1000;
        
        /*
        this.armadura = new Armadura( "Ropa vieja", 5, 50, "Suficiente para tapar tus partes", 20, "https://i.pinimg.com/originals/28/da/a3/28daa3663498c909d99715cc1eaced8b.jpg" );
        this.equipada = new Arma( "Cachiporra", 5, 50, "Arma inútil, pero es mejor que nada", 20, "https://raicesdeperaleda.com/recursos/diccionario/af9190fc88e3c83936ef77ab9b16822e.jpg" );
        this.accesorio = new Accesorio( "Amuleto de la suerte", 1, 1, "Talismán que guardas desde pequeño", 10, "https://images-na.ssl-images-amazon.com/images/I/61YZjlF2U8L._AC_UX395_.jpg" );
        *
        /*
        personaje.modificarPA( equipada.getPlusDaño() );
        personaje.modificarPV( armadura.getPlusVida() );
        personaje.modificarPA( accesorio.getBonusAtaque() );
        personaje.modificarPV( accesorio.getBonusVida() );*/
        /*
        this.armas.add(new Arma( "Arco sencillo", 10, 100, "Arco ideal para los que quieren aprender", 40, "https://w7.pngwing.com/pngs/472/879/png-transparent-longbow-larp-bows-bow-and-arrow-recurve-bow-arrow-bow-weapon-bow-and-arrow.png"));
        this.armaduras.add(new Armadura( "Armadura de cuero", 20, 100, "Armadura de piel básica", 60, "https://www.eltallerdelarosa.com/636-large_default/armadura-dragon.jpg" ));
        this.armas.add( new Arma( "Nada", 0, 100, "No tienes arma equipada.", 0, "https://image.freepik.com/vector-gratis/mano-puno-dibujos-animados_60352-2675.jpg" ) );
        this.armaduras.add( new Armadura( "Nada", 0, 100, "No tienes armadura equipada.", 0, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMgAAADICAMAAACahl6sAAABpFBMVEX///+APQCPRwHMZgD//8zZvHXs0YJeLwXHq13ZvW7TcgCrjUnPawDOagC9oE/HqGPb2wKohkPUdADGxsaMjIzj4+PKyQLU1NSpqanx8fG4uLibm5tOJwCioqL4+Ph+PwBwOAB3OQHZ2dm1WgBdQCN8cmmFd2nYegB+YkaJgnuHfHKnkVptWUb79b91XS5eLwCCbVipVACTSQD14qV3TSNIIwPAYAByPQl1ZlhWNBKeTwDz2pnVgiZ5UiyXg1GegkNhRiyLdUWekGaRdz6rp5m2oWRLJQN+XSb4+Ka8nlno6E329pmFWBn6+rKVg2CnklRjOw3x8YDipUynnoY6GwDk5DS+owHntmbbkDOimHhuTBuNbTDt7WeMUwztx3+nlWVfUkeTYxjaiialdwF3ZTuOeUxaQxs+JxPCcACvZQB+WSPjoj+ddTKJWBPItgGYWQGwhwH//+xnVTRGMRdGNytFLA5cQRtycnJ2b1piW1UqGAV3RgBxWjGUj4I9MSVNOx/VjQDTpAHgyUDgvE3Hjz/FpUDVmADisUyhZQGniA2bdhq+vqu5FD+rAAAa+klEQVR4nO2d61/bRrrHgzDYwSamSI7lqySEuRlsbLANAmzAGOokjSmQcEmgSZo2kDSl203oZsNu93Z2s+f80+eZGV1GsuT4lqYv/HuRD5GNPF891xmNzI0bPfXUU0899dRTTz311FNPPfXUU089/f4UD4ECY6AgixQG8Xw4zLLBsUAoFP/c4/uIQiEYN48HvYW0Dzq+j7QBer5RLG5uHu/vb21hJHYMmH53SPHQGAvDh3E/R4OGMYOSoFoVyQ+qeW7e9Hiq1UqtVkNImwSJDQZ+LzShQJANb+1vFou1WrVW8zsIgRjyePzVKiY63gqHPz8MMcTxJjD48UArVUcQ/007+Ss1DBMMfS6GuGGIqnGxnUGqVVsQDAMs+2E28NtDqBFhGEJXtWodPsjr9X7xxRflW6o8SPUsx/xvSqIa4hgZwsZZPDV18OroKZVKt8yicfyVZPH+FvsbhQqBmLiPotp6SVWOW6Vy6QsHlb236uVROfwDAwPJ4/BvYJR4ACCO70NmtXd2j4eMzFt2RCnbgGDLVCoDWJXi1icmCSFTHH+3kaxa8yhh8NAD85YcWOqcS/uF2oAq/ycliQfD/P59QmFTEOxGVk5dX6fqdZ0qg0qlEgQQ9fayd8Ag4T9RHkYetQ8OVdPTkR7jdgzeEpijvHNysht12yi6Czo5OdnZSWEiL8H2VnWSymb4U0Q8jovviqZyXa3ZQmCEVAoQ3O50WpSkPhtJSKIoptNABUg7ZcgAXjCQDjKQ3B/rPkaYP9Y9ygApm/zilhfFBCB8f7W8HXVEsKMCIPfuSTkFjmaYZKDbJomPhf9yvFE0U0B5QEFbVn2CIFx///btQS4KCE0SmGDS0Wu4MiaTdDPeAWPr/nOzMapGhSuBBVLl589//vWPLw5y7nYQdKWvUibf8h+zXcXYrCVrVlNoFI9SqZ+fvHmDGNKdMBCjuE82vF6/QVIMd4sjhDD8RgNIQXyBIX5+89cXB+BLzQ5VQgFuyBJFkjtVpkGSfHeCJM5iDLWTrVoc6uf1X5t0JpyccHqCfzGAO4q1Hd3ehrQg6udIL6dMIFvdKCXxIH+sTh2qVojr70lENGcHcu0tFz9tlBSEgy+I6D5IlboOwu4ntV7qVrlsBMX11duDg+2mvclRFAqiARaonNvflwe6DBLcKuqNLG4AUUykEES087C2Q3FHc7nt7atugwS2in4dAwQOhYpE1yDsUbYPrmrdBQnwm8Sv1CYWKLoNQSSaW7Dtq2IFyd8lkFB4s6aaA5wqdbX8SSCwJLNNvicTEjIv6RgkHrmP+0FkC2j92mo52iPZ3hgYxPJXOgeJs7/8CTg8yKNO3J2np1ZIckUVZBB5V5HviCP27tei52YVUXTWO7VBkkuqHIMDYJIi1wlI7N0LSFje8m5DCkki5RpX7E6tpkd89KqigdyE/u7+L+0YIkT8MfjLnzeqnlJqOe2IAGPHDUYOdABtO5B0BtJXFyIAUq1UNn5pPUYC/NbWL2/ePHky++J5EYIDZhV1BDD72d5GQ4fKhXulrqUBzSTLumcNejy1ZCrR8oQkFP6mUkkWnz+/epvbLezu5g7cKEA0AUL0AI1eu3StzP+aB4leG54FIMWTRKsTknj4mwGcKQBm46UoMZI7RzV1OfAfg6GrCESSNdTBIJ7q892pVkHYY7+aKGBeliy+FN3gRWrXgPxIQxC7jkAk2hjEU9sptAoS3K8M6iCoEG1cbSOTQO+zbVjiE0EYIGaDeMpP37cIEufLnps3AUSfCviTqe2DHE5IXcH42C/j3jFHpSzkWeXL0xZBAvs1vMDvoTrPZPGPB1TF7bBQfAzEWkPQYEpPL04nWgMZO1ZBytSykv+7KyPeO6wT0keuA4r16LLZscAg5++nW0u/Y5pF0EqsvozhT17nugXykd8XTV0WMUjt0cX5e661xYcQD7UcyUtINJTi+AEufJ2HiLvx6+l6Dg8Y5GIn0hIHZK2/bJRrVWROr5dC8W9cHeBG5ACl4A5YJHfD3wXPyl37zRzVR5eTl/Mt10Pu7e69R+VyrWwmSRaX1WpCOiu01tEOjtg4WYjAoRvkpkczyOT76VZXsfnZdCajMKf3Hl2ndBQ8T0uqJFqRR+tQrff2YuMgA47kQMXM8fRisg3PWtpW+kFyRhHev9RRBlBdSb61u71R31F+BKSRb6URBxRjC8fk6VKrdf2XnJDpVyUrjI7ih8vk/+6ANIlpm1W2ZpVuVIjE3PPkgApCc0y+f9di7xt7k2Z0EIRyurOhJmKwt38j13FBRIVbcnpteSM5oIKocU44Jt2tNvHB6Whftp+SnL2nGqUGZ6+86Li0O59Aci9+p66bkDpocJxHW56NRNZNJgGBUTBJCUD8P2PncrqizYLYnkB0p5KkaPn9qluVHl1ijsnTli2CTWIhkZmXyL1KVWgl77/A8d7MiKV0FM1/c+aiIzl0B5J7l7gVMohfNccPkHeRLsR0yyBxDkxiIckzJ6mSt+zxDA4cvzto0rnSufUlDimxvk2NW7JtPKW0O1XU+u0qaZJq5aeXk0SnfS2DxMPcOzAJo+TrSEoez83KfuRJrhnnkqLLiQjZpDQWmx43TKjNyE0kovukqM1/BqrlKjaH5lZgEIkRZ1tMv+x+8U+QuBgmK5uMkj259sLpi3wggp3rI7VDiq5zxiez3LpOoq/2GJcCMDaSmjn8XnTFPCUwx7nKMSowLYOMbRUryecHYBKLe4FNwLVKx2w8kGgi3qPrEbqjCHL6gpKx5E7OIIkoOPRZXNXrBYPUIDo0c2CDtAoSD2+iAv7zsohIsrR75bM7pVoxDM4SfrP9sShJL3NBs6ETOZWcagkkHBtgjQqFAU03eJVhDki9YJBWQQJbOHEUkztpjJKhUPLR1AbeBBaafmHyLTGai2KstHZMyiWst2Ahq5OX6OYmbcbw43JVLoNXGeaASG8DZGy/QupRBaGAg2UN/5LTb/5CLjOL413zLTGXSMxuS+iH8ahqkPW6Do9dilpAoIVeThUNp8Lm8JZSz5FX7RkcF4ijbZDBgUoytZsWDBQZzqXeII5zLyjfiiaCgdg6DNO9FJkll327fi0txC2LVKxHo7m315QxNIxy6uT0YnTy2YrhWNg1GPFJa661r7c60I4kN07AZwhKhmHSCS1+sUlUPxLHI+geyrhbWo6EuG18aDlSPysNL7m1WEe2uHpOG4NgeMupl5c4OBbONI5R7Fjw4U+CdadsoDhfJC2CupqfTKaWIWUwSpbpEw/e8SzZiYtNooK4l9AnBBM5sMyNGDaJ267lDnE43NGcDEFUKGPoGDunJMbPXK80jkv08bKcdbfY/bKbmm9pNybKbpyLxUK5mPzmeItnUZXDJiEgOQ5XvdjsOI94oijUObt189ivaTEdvYKwgI+Ark0Pcc2pAAO8CvTK5XpGB0hmclJutWkM8bhRqOiT/4HSqQAk4kv4+EF4Ibm5vxVmx6YP1GjHnoVMMo0+Kc4tS33iesx0zngoMMayYe7J1ctysuJXT60uAJJMBRgvNYzJyTmXi868DFgpE020eFMhuE9IdIv8cHEuCEwhOaAfQYaZ/iukXDSzSmvZhMU+zEOW1TwLAQRZtLd/f/9485skcqdBQxXNGBaMyUGXa0HjQN6QhZ+UXKv3q+LQo8BHJpN+P/yTLP1wOTQ6JIgnNWoIyDDf/bq8u7vrdh884Vn02AR6yCAUigchpCFYxpAJwujJBAKArs2gRTVC4S1tpO5BbIyqmvyPy+UaVDmwQfLwIxNt+cZbnN2aWT95ebID1fXyUskMwcmHCqmqxzwMP37qAD19sLmJH5vYR49U8LF3B9E/v1NNAAD+egBtWYHM1sqAcXmhY4yOPgPHch2in1SOLFhqSEi3cQcxFJ5Nw4RckM+HhobI2bMA4rlpAjGCFYRu6ydVMpySnAAIBVmWxokq9dqEMTq64lJBVA4mAz/npd12boWOJdyk1RrSdPG6jHeumzzcQf6KM8KgvqSAQGwwRvcQh+uVwcGg12Wh0A4IlLc0PoeskyiPyuTzb34UZKDiaIybGgVaHCH5dmjUrDkMcmRwKOioIrxv6+Z0kFNJshkfPv3QsPK0XFWHcBPdPmkAYk9CQ4A9StcvbTBGDzGH65nOweTRYYZpDwSRiOqJMsQkPuV1uUSNpOyt+p1ArM5lZgCKWrl8YocxOkkM4jI4svg6CkqbIGgJQtJONUxQ5Oy9ck0fDN7/XfXbw2gk6g75OopHp9bQMBvEhesH8e5RHOsX7YLcCM/oJFqo+DKnL8sllUW76QA01qd1qtVqqVS1AhCI0sajp6eXmfN6Y1ARMndHswfD4DfKwnnbIECyrZ9Oda+h8+z71482MItx08FWpbIFpYohwBRgCwcKLWU9HhnJMllGz70o1kff2/ZvTYl/I+rXRRnW8rDAXL5G9xyqpVJDEoTi1RHKwACWUMAUjhSgBcD4egT0bT5P3Jq8W1BGmYm2N2LzvxogeqAMyZDJlOzp00cb1xsbxtMSNiBoAyp6/BAQXp9mlczF+ZBFVo5nLtfdB4jjwd+Gs0bKGh2SLjoCGXczFIlWHYcZScnnZYA5PX19797LnR30CIgOhZ+v2IAjOzv37sFbsllFkfOqN1lJLEiHX90Bijt3XQ/+rlCONZoXhgCk7acVuKgoUCSMXucVsS+bkYd8+Xz+4iKjKEoWQZ3eu3dvB8kYPwD4zAM+11zLFucfIw/ufAnedWfkIe1YoxkBwqTlDRya4lxUEGkQo87LOMvDhTbGgKBkWUGC8ed9duNEv5kx/deEJGe+/goHO5jlR+LOqsshy7QPEkikmTRjTzLMiCTRKxk5PzzUQHnZ9IbzrMP7RvOy75lLS1ojIyYXEKHmXKy1uxMwCCBm3wKf1a60TxYk47CCePJ5emDDeWQf+A3ZNN5zwQEEnZgkX5y1Ri6py5ZHv3S+2C4IOysyFt+i0vDQcFbsY+qkEKlFQDFRPHsG4xXMYCadGRwjH4BDCyZFQZ/3vtWboZr4dbjmaetgjdbebJQ6XX746e+DK3s0iGtyCJomZxA0E/mScIz8RAELOAmL7ZZ2fhytgdeP1fiEYUUSbBA+fPvTwx+hFtxFF3jlGTXQBZjpMcN7Bt3REQ1CcTykOIaJOwrtFhIuCoPqS9cP1HCvoTxj9a8PD8lICAae7Onv3nOtDGX75BXXnEb3zLUySVnM4KCTW4YYMTvf0gqdrtA0LofWcMfuJfs0QSYWbTBGHrsMnY0aIz1ShCx0hnOaUc5cCzrJK9fcA90ee4ZXqtmr3fyLsi9Isoa7ahQdxZcxQuUnFWPkSxetFcN35mSJyaNefU8bvOtMe/VQ5zg/hC74n5pnMSRVym2mLZS0kGx8CyljoOQViaA8tOeAGbg6JugJ/yVBdUPNuhodc/pPQysqx/8M4Kr4N82zVDcbLrSXtnDScvAt4l8UCraKzvG1hUO/6JCWVuB0wyjPzumH1J9W75DgUqv7bQ2E0WrX++m2GvnYOCGoKyVgjQxByftoqzx9oIFYOVwLPp8+ajhr5pVLdy7Dzf6Nf/fOnMpx+99k+LKer5mJtqIdJy17yb7hDC55Co3yL9dXdxxAXOp7UKG4h6bhmA6P7kgzzjM6SQDH7dv/wLnNp+fI9qI9kHA3APH5hmWCYjgYHtJjW9eiQb6AfC2jCZQLJzPMBFGyhys6ydlzCOP2XdecuUfOL8Y+Pu46BZccolwF0VH0WFHXDWBAD+YagPjRTbBBPHx8jMTQmcsID8yBXWzFBOITW9zUiBWetc27FIiBQjKYtgACkzwryQINgnLIP9HRV/gYNs4K4v+R4lDLqanwQ21vY26lxXojEBBBAQ/z+f5jDPyrx1+ZQFbUd7s0kId4oRodwtN0EHRXebx8PaeZA0OZnKutIGkQ6zSIz9efzyjYw26PPK5zKddKHcghukAPURidITPOaQ75NzDr6OHCnGEO4zdVELmNIGkU60zeZxVM4T/g5GmyxMrRKvGcQyMdEJDbt/EgXy1ob/1xUj3T32/fNl2OhVXjU4bbCBLWGusS1dDXg6ARWJvFhVMFDu9RIPjno2wfAkHEZ/pwB0e10zz8t0a3sHJ2eHh0NEp9RhuVRKvruqLLRsz0D2syPgN6jS/vPn784IGefY/6EfAzCgQP/FlGQCDmFH1kd2nqlWl9uhtZNse6ME4F/7CN9oxRfYlbrTPKCmrWwpfaB20jgNzW3o3pmuPw5Vu+SRKatsR6eskAydqBrFjDXPVtcnwPG41Eb15ivr1NfAuHkctIBh+VMNNiAq4rh9FpA0SxA7FynBHHG9L+u6rFum/1v7hwo2Zk4Ygc3WsWRJlq8esSrOVQWOYMkIwNx2qdQcjxI+vxhTnXYwxy27WAx4/eMdQsSL7VVt4aIuIsBSI3DhGsOfX4mRUEdJeA3LrAYzvUw8l+6Bm04mr4VmvPkNSFiDtBgWhbuGiQQ8tgD9Xj9SUSRECyWZz0zhrmrLxQWJxaLAiKWoSzrfmWNUT6opzRslC7mw0kK4iTZyHnGvhfxPEj8VFI23PDzhzSGhfjeW5mrSDgjq5F3+LXzSEirfO8DqJQ+4H1nywgZ065bGUPEDHIfxlckMAn9yjLWkCUAt5RGB8LcxOLEiqwreWtSNQcIumloAFCbdnMOIGsEserSwGuI3T4IQL5QPLfimvBLgmqSKL+8EucjUwUGEBrpSYGZiyNVnQ6ZIBQuxwN41hi4YjCOxw6Qlo1XO4u8Sx0rlWYHtqDIJkdieUWs6gmNt9vWRstYTlyQwehHwBg9J+sFx4fREskrgXaZivETgDyLXZZd3LuQ94ZRFkzhfYYIhFaWKeLjJsbLXE2bIAoNIgeJAtmkEM4tHqIDs6t9htQBPAQpuTYIEJ0Zm5/ftE2n2MxlkEHgSSz2HS4h6xzkTTa46eByDSIHiSWerHS3+8j3ranvmFPPYyR7hKDuBP/94dQkJ9YE+xqLEiYsVQNIGHEpktJfX/ChYyJFr2n2TCPb8ECoh44MwXRkYaE76xJ45E/4AvHTk8J6PrUgdQvwAe5gjjVbLjHLMlXQJv9NBDas/J9RpCYSRaOyH/nfLRBDvEbAWnulBhaS0mAsmi6QnaxTsTOFApN3nEHzzKvsKMQ0UFoz5Lc1H/tap+WvYifEeugoP8XikGoskb+CfHzBfrUWLarveGZQpMPJAaXLMkXhYjetNDJd9FNG8iG41B7DaesVQ3pMI9AxHXTMIMzi+ZnVhxAgKTJcLd6Fqoi2tq8ybOE9TSdjG1WHrSXVo1wOcMJGSWO9JI5JQU4K0nGvrEKz8w0k4HrPAtVER2Efh6ugHp9wx/q2pEzH/3SwqrqgChuFIGkEAuJxbucln/CXDN5i7V6FnYBLZNRnpWdQvN6w0TWvnHF9MoCpoKUgAtLRkJTHOtHBycE6jrJ+fZvrSNFxi2elUa7eNW7JbRnSWTSqP/fUhMXdHuszun/O1MLJASJJUSw+CndVQX0xGYnIAHrVIRxo6qkglCmzyySRKYdshhEq+gkMascq/phiVwfi+K6cymFGZ6b6gQkPGtdvMY7h0mHYuqz5klrqRrJ2uge6W88o6zj0/CYPnfCph/XnUuaCt4IRLj2QeKcZZIL5TCmg1ChDl1owhQ2ZnsYHHu0dQx7CnWxjhUjmSuPa3qIbf97qIJ1S6W4HKr10BTqnLpAkdEvvFE/9PhAAWLD0S+L9lvEAzPYJO3e+DQUQUVEEATDLCTdYxBTEZnhtMVIcsCo7GfUwLU0VSdx3H6o/Bq6MMpah1/3CaEuqN//qKHgWCdr2jJ1RRcjEa0fVk2iLdnu0eM9c+DoF2ftQYhJsh0l3hvoywXc7ujsNM/zE1oWxi4whuLBHOqs3g9nKZOsHJmGu0dHPZZmVcnpkSkcJcx8Z98kC1U9us4FUS8XUHcwk1jH2ZduIEQuaMyH1RcOCYZsGG51bsHCIRdUTxTeOSwijE3AOzrYwIgVno0uxUIaFHYdUrfCKHTofnGNDyb0PK2ZijiRVNDe6DszuRm5AmuKalKnfimyKHcKAmNPGJ7L4rggj/+h7EsbRJgIstSqqkwPVVjUwXz9dWLUdj2z5nT3iZ3PdgoSTszQ7WYEb9jCz2ihRpIyiAwzHvoOimIeqlQ/fl2ZNZJgwTkdigSU905BOHMlxTUF1y00i6cHixYuTcvD/aYX6yYWtESONFTOvhVeUzoEYc1fnx1HY8VJCzXx9ExUmg7FTSsU9IvK1DzT7yxmnoMgaORbYxNCp8FuUXgpLeC6xS6lyVelgPJkDOa7pbQJ5EWukLdlwIJmc7rQ0LduRApSd0HGpqOkQQnPivl+OUu++FmQIdQtSy2038kFbirrQEHMyWOTZR2n3uy82F2QG9wyecowNs70Z8W1efwNDhNraNWSNd8KokcqctONwh0AeJSDZcepd2i62yD8ehQ321w0IyxOa9/gwE+Hbxgrj/UJWJiom33TAoAQnndIjvuvYotT7e1fdBK7FJ0J4UXtwnzEODX6uyaWe1r0wJmJWMNwB4AxNO9w9q3gfKe9lkWBGZy0gku7M5avOo9bllXpoICpdsNwRwBhCKMGvsV1GeQGh58oDi/VTdXqtniY+5dwo3BHAHHUiDTwrRa/N++jiuBmm+fqPLZufVimB8qPzQhOGMS3IKALjfLWdKcTK4t43LOE6lMIa93OZZ4F486voW9BjmUa+Faka39+QB2v0/Sft27nol1J5OJso3AnAJCDnX2r24o7Tf+tN+JNQSJMBEINwx0DwFuElr8fr9uyJi1zkKDdSPya4oRBmk7UU4nN3336RIK8bLUINW601Nkw3GVy44OfElvdJNN1xRJRS7RTQYJvITcMd3K3HHJwq5tkui9+ej1qfkrGiAm8KtUw3NWdGIFmb3V8SgVj07PLbmrnvJGA8f6whuGu+hbQfnbfuoG+AZybmR1H3+mNn3WmggRPNZzDPZ+VFtXEG5v47L6FFB8L81xiaXZ8GXDSWfTwGx4pnuBBuNtGSQYmBBMRtXKH+O62uZ0owLJ8hJtJJOanptYWRSGjzccjawXGgiIrjFCYggnB5/4Tms4KBQJBlg1HYN4lZcmK51iMmyqIjCKrUmCKWVib4MK/HyM0UDwY49ZEdQsPRNHE1KL6N5EKi1Pz0xH+8/0R0JYViM0YKyTBcIxTxX/Gv2Tapliuoz9M8TsS+7mbwZ566qmnnnrqqaeeeuqpp5566qmnnmz0/9aBmYHf9PW+AAAAAElFTkSuQmCC" ) );
        */
        
        this.equipada = new Arma( "Nada", 0, 100, "No tienes arma equipada.", 0, "https://image.freepik.com/vector-gratis/mano-puno-dibujos-animados_60352-2675.jpg" );
        this.armadura = new Armadura( "Nada", 0, 100, "No tienes armadura equipada.", 0, "data:image/png;base64,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" );
        this.accesorio = new Accesorio( "Nada", 0, 0, "No tienes ningún accesorio.", 0, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMoAAAD6CAMAAADXwSg3AAAAA1BMVEX///+nxBvIAAAASElEQVR4nO3BAQ0AAADCoPdPbQ43oAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAeDcY+AAEwjzW4AAAAAElFTkSuQmCC" );
        
        this.combate = new Combate( null, null, true );
    }
    
    public String getUsername() { return username; }
    
    public String getPassword() { return password; }
     
    public String getNombrePersonaje() {
        return this.personaje.getNombre();
    }
    
    public int getVida(){
        return this.personaje.getPV();
    }
    
    public int getDaño(){
        return this.personaje.getPA();
    }
    
    public void setPassword( String password ) {
        this.password = password;
    }
    
    public void setPersonaje( Personaje personaje ) {
        this.personaje = personaje.getBase();
    }
    
    public ArrayList<Arma> getArmas(){
        return armas;
    }

    public Arma getEquipada() {
        return equipada;
    }

    public void setEquipada(Arma equipada) {
        this.equipada = equipada;
    }

    public Armadura getArmadura() {
        return armadura;
    }

    public void setArmadura(Armadura armadura) {
        this.armadura = armadura;
    }

    public ArrayList<Armadura> getArmaduras() {
        System.out.println("2222");
        return armaduras;
    }

    public void setArmaduras(ArrayList<Armadura> armaduras) {
        this.armaduras = armaduras;
    }
    
    public ArrayList<Accesorio> getAccesorios() { return accesorios; }
    public void setAccesorios( ArrayList<Accesorio> accesorios ) { 
        this.accesorios = accesorios;
    }
    
    public Accesorio getAccesorio() { return accesorio; }
    public void setAccesorio( Accesorio accesorio ) { this.accesorio = accesorio; }
    
    public int getOro() { return oro; }
    
    public String getFotoPersonaje() { return personaje.getUrl(); }

    public void restarOro( int oro ) { this.oro -=oro; }
    
    public void addArma( Arma nueva ) { armas.add( nueva ); }
    public void addArmadura( Armadura nueva ) { armaduras.add( nueva ); }
    public void addAccesorio( Accesorio nuevo ) { accesorios.add( nuevo ); }
    public void equipar(String tipo , String nombre){
        
        int index = this.indexofHerramienta(tipo, nombre);
        
        if(index != -1){
            if(tipo.equals("arma")){
                Arma antigua = this.equipada;
                Arma nueva = armas.get(index);
                
                if( antigua != nueva ) {
                    System.out.println("Daño antigua: ");
                    System.out.println(antigua.getPlusDaño());
                    System.out.println("Daño nueva: ");
                    System.out.println(nueva.getPlusDaño());
                    
                    this.personaje.modificarPA(-(antigua.getPlusDaño()));
                    this.personaje.modificarPA(nueva.getPlusDaño());
                    armas.remove(index);
                    armas.add(antigua);

                    this.equipada = nueva;
                }
            }else if(tipo.equals("armadura")){
                Armadura antigua = this.armadura;
                Armadura nueva = armaduras.get(index);
                
                if( antigua != nueva ) {
                         System.out.println("Vida antigua: ");
                    System.out.println(antigua.getPlusVida());
                    System.out.println("Vida nueva: ");
                    System.out.println(nueva.getPlusVida());
                    this.personaje.modificarPV(-(antigua.getPlusVida()));
                    this.personaje.modificarPV(nueva.getPlusVida());
                    armaduras.remove(index);
                    armaduras.add(antigua);

                    this.armadura = nueva;
                }
            } else if( tipo.equals( "accesorio" ) ) {
                Accesorio antiguo = this.accesorio;
                Accesorio nuevo = accesorios.get( index );
                
                if( antiguo != nuevo ) {
                    this.personaje.modificarPA( -antiguo.getBonusAtaque() );
                    this.personaje.modificarPV( -antiguo.getBonusVida() );
                    this.accesorio = nuevo;
                    accesorios.remove( index );
                    accesorios.add( antiguo );
                    this.personaje.modificarPA( accesorio.getBonusAtaque() );
                    this.personaje.modificarPV( accesorio.getBonusVida() );
                }
            }
        }
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }
    
    public Personaje getPersonaje() { return personaje; }
    
    public ArrayList<String> getMovimientos() {
        return personaje.getNombresMovimientos();
    }
    
    public Combate getCombate() { return combate; }
    public void setCombate( Combate combate ) { this.combate = combate; }
    public int getCombateActual() { return combateActual; }
    
    public void resultadosCombate() {
        
        EstadoCombate estado = combate.getEstado();
        this.equipada.restaVida();
        this.armadura.restaVida();
        
        switch( estado ) {
            case GANADO:
                oro += combate.getEnemigo().getRecompensa();
                combateActual++;
                if( combateActual > record )
                    record = combateActual;
                break;
            case PERDIDO:
                oro -= oro / 2;
                combateActual = 0;
                break;
            case RENDIDO:
                oro -= oro / 2;
                combateActual = 0;
                break;
        }
        
        if( estado == EstadoCombate.GANADO || estado == EstadoCombate.PERDIDO ) {
            if(this.equipada.getVida()<= 0){
                this.personaje.modificarPA( -equipada.getPlusDaño() );
                int index = indexofHerramienta( "arma", "Nada" );
                this.equipada = this.armas.get( index );
                this.armas.remove( index );
                this.combate.setAlgoRoto( true );
            }

             if(this.armadura.getVida()<= 0){
                 this.personaje.modificarPV( - armadura.getPlusVida() );
                 int index = indexofHerramienta( "armadura", "Nada" );
                this.armadura = this.armaduras.get( index );
                this.armaduras.remove( index );
                this.combate.setAlgoRoto( true );
            }
        }
    }
    
    public void modificarPuntos(){
        this.personaje.modificarPA(5);
        this.personaje.modificarPV(5);
    }
    
}
