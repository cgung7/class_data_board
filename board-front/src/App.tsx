import { SocialLoginButtons } from "./components/SocialLoginButtons";
import LoginPage from "./pages/LoginPage";
import { useAuthStore } from "./stores/auth.store";

export default function App() {
  const { isInitialized, accessToken, user } = useAuthStore();

  if (!isInitialized) return <div>Loading...</div>;

  const isLoggedIn = Boolean(accessToken && user);

  return (
    <>
      {isLoggedIn ? (
        <>
          로그인이 된 경우
        </>
        // <MainRouter />  // 로그인이 된 경우
      ) : (
        // <AuthRouter />  // 로그인 필요
        <>
          로그인 필요
          <LoginPage />
        </>
      )}
    </>
  );
}